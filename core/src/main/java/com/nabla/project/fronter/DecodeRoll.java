package com.nabla.project.fronter;

import javax.annotation.Nonnull;

/**
*
* A role is on try (2 tries are a frame)
* 
*/
public class DecodeRoll {

	private final Character roll;
	private int pin = 0;

	private boolean isSpare = false;
	private boolean isStrike = false;
	private boolean isMiss= false; // TODO might not be needed
	private boolean isFrameComplete = false;

	public DecodeRoll(@Nonnull final Character aRolls) {

		this.roll = aRolls;
	}

	public int compute() {
		
		if (roll.equals('X')) {
			this.isStrike = true;
			this.isMiss = false;
			this.pin = 10;
			this.isFrameComplete = true;
		} else if (roll.equals('-')) {
			this.isMiss = true;
			this.pin = 0;
			this.isFrameComplete = true;			
		} else if (roll.equals('/')) {
			this.isSpare = true;
			this.isMiss = false;
			this.pin = 10;
			this.isFrameComplete = true;
		} else {
			pin = Character.getNumericValue(roll);
			
			if (pin < 0) {
				throw new IllegalArgumentException("Unexpected value");
			} 
			
			//if (pin > 9) value must be X
			//if (pin == 0) value must be ???
			//this.isMiss = false;
		}
			
		return pin;
	}
	
	public boolean isSpare() {
		return isSpare;
	}
	
	public boolean isStrike() {
		return isStrike;
	}	
	
	public boolean isMiss() {
		return isMiss;
	}	
	
	public boolean isFrameComplete() {
		return isFrameComplete;
	}		
}
