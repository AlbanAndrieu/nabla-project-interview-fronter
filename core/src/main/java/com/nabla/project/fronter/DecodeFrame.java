package com.nabla.project.fronter;

import javax.annotation.Nonnull;

public class DecodeFrame {

	//public Integer DEFAULT_FRAMES_MAX_NUMBER = 10;
	public Integer DEFAULT_TRIES_MAX_NUMBER = 2;

	private final String rolls;

	private int score = 0;

	public DecodeFrame(@Nonnull final String aRolls) {

		this.rolls = aRolls;
	}

	public int getScore() {
		return this.score;
	}
	
	public int compute() {
		
		//TODO check number of frame (not required)
		int numberOfRolls = rolls.length();
		
		// We count the number of time we can try to hit all the pins
		int triesCount = 0;
		// We count the number of pins hit until all the tries have been done
		int frameScore = 0;
		
		for (int index = 0; index < numberOfRolls; index++) {
			DecodeRoll aRoll = new DecodeRoll(rolls.charAt(index));
			
			System.out.println("Rolls : " + rolls + " - "+index+"[" +rolls.charAt(index) + "]");
			
			int pin = aRoll.compute();
			
			frameScore += pin;
			
			if (aRoll.isFrameComplete()) {
				//We register the score
				score += frameScore;
				//And reset the frame score and number of tries
				frameScore = 0;
				triesCount = 0;
			} else {
				//We do not yet register the score, before we have another chance to score!!!
				triesCount++;
				
				if (triesCount > (DEFAULT_TRIES_MAX_NUMBER -1)) {
					//We are running out of tries
					//We register the score
					score += frameScore;
					//And reset the frame score and number of tries
					frameScore = 0;
					triesCount = 0;				
				} else {
					System.out.println("Try again");
					
					if (index == (numberOfRolls - 1)) {
						System.out.println("No more input!!!");
						//Let score whatever you did
						score += frameScore;
					}
				}				
			}
			
			System.out.println("Try count : " + triesCount + " - Temporary score : " + frameScore);
			System.out.println("Global score : " + score);
		}
		
		
		return score;
		
	}
}
