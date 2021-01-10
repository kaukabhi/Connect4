package com.game;

public class Player { 
	private String name;
	private Disc[] discs;
	private int playId = 0;
	private boolean isMyTurn = true;

	public Player(int count, String color) {
		discs = new Disc[count];

		for (int i = 0; i < count; i++) {
			discs[i] = new Disc(color);
		}
	}

	public boolean play(boolean isMyMove) {

		if (playId > discs.length)
			return false;

		discs[playId++].setAlreadyPlayed(true);
		isMyTurn = isMyMove;

		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Disc[] getDiscs() {
		return discs;
	}

	public void setDiscs(Disc[] discs) {
		this.discs = discs;
	}

	public int getPlayId() {
		return playId;
	}

	public void setPlayId(int playId) {
		this.playId = playId;
	}

	public boolean isMyTurn() {
		return isMyTurn;
	}

	public void setMyTurn(boolean isMyTurn) {
		this.isMyTurn = isMyTurn;
	}
	
}
