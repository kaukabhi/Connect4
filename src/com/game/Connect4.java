package com.game;

import java.util.Scanner;

public class Connect4 { 

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("Number of rows in the grid? ");
			int rows = scanner.nextInt();

			System.out.println("Number of columns in the grid? ");
			int cols = scanner.nextInt();

			Grid grid = new Grid();
			grid.initialize(rows, cols);

			char ch = 'Y';

			do {
				System.out.println("Column?");
				int col = scanner.nextInt();

				System.out.println("Disc color?");
				int color = scanner.nextInt();

				Move move = new Move(0, col, String.valueOf(color));

				boolean isGameOver = false;

				try {
					isGameOver = grid.play(move);

				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}

				grid.printGrid();

				if (isGameOver) {
					System.out.println("Game Over!!! You win!!!");
					System.exit(0);
				}
				
				System.out.println("Continue (Y/N)?");
				ch = scanner.next().charAt(0); 
				if (ch == 'N' || ch == 'n') {
					System.out.println("Bye! Have a nice day!");
				}

			} while (ch != 'N' && ch != 'n');
			
		} catch (Exception ex) {
			System.out.println("Error occurred during the game." + ex.getMessage());
			
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

	}
}
