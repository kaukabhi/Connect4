package com.game;

public class Slot { 
    private String discColor = null;
    
    public boolean isEmpty() {
     return discColor == null; 
    }

	public String getDiscColor() {
		return discColor;
	}

	public void setDiscColor(String discColor) {
		this.discColor = discColor;
	}
    
}
