package com.game;

public class Disc { 
    private String color;
    private boolean alreadyPlayed = false;
    
    public Disc(String color) {
      this.color = color;
    }

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isAlreadyPlayed() {
		return alreadyPlayed;
	}

	public void setAlreadyPlayed(boolean alreadyPlayed) {
		this.alreadyPlayed = alreadyPlayed;
	}
    
    
}
