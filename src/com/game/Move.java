package com.game;

public class Move { 

	private int row, col;
	private String discColor;

	public Move(int row, int col, String color) {
		this.row = row;
		this.col = col;
		this.discColor = color;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public String getDiscColor() {
		return discColor;
	}

	public void setDiscColor(String discColor) {
		this.discColor = discColor;
	}

}
