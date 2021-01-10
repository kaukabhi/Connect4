package com.game;

public class Grid { 
	private Slot[][] slots;
	private Player player1, player2;
	private String prevColorPlayed = "";

	private static final int[][] neighbors = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } };
	private static final String COLOR_1 = "1";
	private static final String COLOR_2 = "2";

	public void initialize(int rows, int cols) {

		slots = new Slot[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {

				slots[i][j] = new Slot();
			}
		}

		player1 = new Player((rows * cols + 1) / 2, COLOR_1);
		player2 = new Player((rows * cols + 1) / 2, COLOR_2);
	}

	public boolean play(Move move) throws Exception {

		boolean validPlay = true;

		validate(move); // validate the input

		int[] loc = findFirstEmptySpaceInColumn(move.getCol()); // find the first empty slot in the column

		if (loc.length == 0) {
			throw new Exception(String.format("No empty slot found in column %d.", move.getCol()));
		}

		// Players play alternatively
		if (player1.isMyTurn()) {
			validPlay = player1.play(false);
			player2.setMyTurn(true);

		} else {
			validPlay = player2.play(false);
			player1.setMyTurn(true);
		}

		if (!validPlay) {
			throw new Exception(String.format("You used up all your discs."));
		}

		slots[loc[0]][loc[1]].setDiscColor(move.getDiscColor());

		prevColorPlayed = move.getDiscColor();
		return isGameOver(loc, move.getDiscColor()); // check if the game is over

	}

	/**
	 * Find the first empty slot in the given column.
	 * 
	 * @param col 
	 * @return int[]
	 */
	private int[] findFirstEmptySpaceInColumn(int col) {

		for (int i = slots.length - 1; i >= 0; i--) {
			if (slots[i][col].isEmpty()) {
				return new int[] { i, col };
			}
		}

		return new int[0];
	}

	/**
	 * Checks if the game is won by any player.
	 * 
	 * @param loc
	 * @param discColor
	 * 
	 * @return boolean
	 */
	private boolean isGameOver(int[] loc, String discColor) {

		for (int[] dir : neighbors) {
			if (checkNeighbors(loc[0], loc[1], discColor, dir, new int[] { 0 })) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Scans the neighbors of each slot to check if 4 of the same color exist.
	 * 
	 * @param row 
	 * @param col
	 * @param color
	 * @param dir
	 * @param count
	 * 
	 * @return boolean
	 */
	private boolean checkNeighbors(int row, int col, String color, int[] dir, int[] count) {

		if (count[0] == 4) {
			return true;
		}

		if (row < 0 || row >= slots.length || col < 0 || col >= slots[0].length)
			return false;

		if (slots[row][col].getDiscColor() == null || (!slots[row][col].getDiscColor().equalsIgnoreCase(color))) {
			return false;
		}

		count[0]++;

		return checkNeighbors(row + dir[0], col + dir[1], color, dir, count);
	}
	
	/**
	 * Validates the input data.
	 * 
	 * @param move
	 * @throws Exception
	 */
	private void validate(Move move) throws Exception {

		if (move == null) {
			throw new Exception(String.format("Invalid move details."));
		}

		int row = move.getRow(), col = move.getCol();

		if (row < 0 || row >= slots.length || col < 0 || col >= slots[0].length) {
			throw new Exception(String.format("Row [%d], Column [%d] are invalid. ", move.getRow(), move.getCol()));
		}

		if (prevColorPlayed.equalsIgnoreCase(move.getDiscColor())) {
			throw new Exception(String.format("You cannot play twice in a row. "));
		}

		if (!slots[move.getRow()][move.getCol()].isEmpty()) {
			throw new Exception(String.format("Column %d is full. Cannot accept any more discs.", move.getCol()));
		}

	}

	/**
	 * Prints the entire grid.
	 */
	public void printGrid() {

		System.out.println("\nPrinting the grid...");
		System.out.println("\n\n");
		
		for (Slot[] s1 : slots) {
			for (Slot s2 : s1) {
				System.out.print("\t" + (s2.getDiscColor() == null ? "*" : s2.getDiscColor()));
			}
			System.out.println("");
		}

		System.out.println("\n");
	}
}
