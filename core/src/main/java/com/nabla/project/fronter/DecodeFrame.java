package com.nabla.project.fronter;

import javax.annotation.Nonnull;

public class DecodeFrame {

	// public Integer DEFAULT_FRAMES_MAX_NUMBER = 10;
	public Integer DEFAULT_TRIES_MAX_NUMBER = 2;

	private final String rolls;

	private int score = 0;

	private int isPendingBonus = 0;	
	private int isPendingSpare = 0;
	private Float isPendingStrike = 0f;

	public DecodeFrame(@Nonnull final String aRolls) {

		this.rolls = aRolls;
	}

	public int getScore() {
		return this.score;
	}

	public int compute() {

		// TODO check number of frame (not required)
		int numberOfRolls = rolls.length();

		// We count the number of time we can try to hit all the pins
		int triesCount = 0;
		// We count the number of pins hit until all the tries have been done
		int frameScore = 0;

		for (int index = 0; index < numberOfRolls; index++) {
			DecodeRoll aRoll = new DecodeRoll(rolls.charAt(index));

			System.out.println("Rolls : " + rolls + " - " + index + "["
					+ rolls.charAt(index) + "]");

			int pin = aRoll.compute();

			frameScore += pin;

			// if previous was a spare or a strike we must double if triesCount
			// is 0
			if (isPendingBonus > 0) {
				System.out.println("Pending bonus : " + isPendingBonus + " - Try count is : " + (triesCount + 1) + " of " + DEFAULT_TRIES_MAX_NUMBER);
				if (triesCount == 0) {		
					isPendingBonus--;					
					if (aRoll.isSpare()) {
						System.out.println("A spare!!! A the first try, is not possible, no bonus added");
						//So we decide / means 0/ and no bonus added
						System.out.println("Bonus not added to score : " + 0 + " - Remaining bonus : " + isPendingBonus);
					} else {
						if (isPendingStrike > 0) {
							int pendingStrike = new Float(isPendingStrike + 0.5f).intValue();
							System.out.println("Pending strike : " + pendingStrike);
							System.out.println("Bonus for " + isPendingStrike + " strike added to score : " + (pin * pendingStrike) + " - Remaining bonus : " + isPendingBonus);
							score += (pin * pendingStrike);			
						}
						if (isPendingSpare > 0) {
							System.out.println("Pending spare : " + isPendingSpare);
							System.out.println("Bonus for " + isPendingSpare + " spare added to score : " + pin + " - Remaining bonus : " + isPendingBonus);
							score += pin;
							//isPendingSpare--;
						}												
					}
				}
			}

			if (aRoll.isFrameComplete()) {
				// We register the score
				score += registerFrameScore(frameScore, aRoll.isSpare(),
						aRoll.isStrike());
				// And reset the frame score and number of tries
				frameScore = 0;
				triesCount = 0;
			} else {
				// We do not yet register the score, before we have another
				// chance to score!!!
				triesCount++;

				if (triesCount > (DEFAULT_TRIES_MAX_NUMBER - 1)) {
					// We are running out of tries
					// We register the score
					score += registerFrameScore(frameScore, false, false);
					// And reset the frame score and number of tries
					frameScore = 0;
					triesCount = 0;
				} else {
					System.out.println("Try again");

					if (index == (numberOfRolls - 1)) {
						System.out.println("No more input!!!");
						// Let score whatever you did
						score += registerFrameScore(frameScore, false, false);
					}
				}
			}

			if (triesCount == 0) {
				System.out.println("Frame is closed");
			} else {
				System.out.println("Try count : " + triesCount + " of "
						+ DEFAULT_TRIES_MAX_NUMBER);
			}
			System.out.println("Global score : " + score + " - Temporary score : " + frameScore + " - Pending bonus : " + isPendingBonus);
		}

		return score;

	}

	private int registerFrameScore(int frameScore, boolean isSpare,
			boolean isStrike) {
		
		System.out.println("Register score - Temporary score : " + frameScore);
		
		if (isSpare) {			
			isPendingBonus++;
			isPendingSpare=1;
			System.out.println(isPendingSpare + " spare!!!, Pending bonus added : " + isPendingBonus);
			//return DecodeRoll.MAX_PIN_NUMBER;
		}
		if (isStrike) {
			isPendingBonus+=2;
			isPendingStrike = isPendingBonus / 2f;
			System.out.println(isPendingStrike + " strike!!!, Pending bonus added : " + isPendingBonus);
			//return DecodeRoll.MAX_PIN_NUMBER;
		}
		
		if (frameScore > DecodeRoll.MAX_PIN_NUMBER) {
			if (isSpare) {
				System.out.println("A spare!!!");
				return DecodeRoll.MAX_PIN_NUMBER;
			} else {

				// If we want to make it simpler, we can remove this rule and
				// return DecodeRoll.MAX_PIN_NUMBER
				// But let have some fun!!!
				System.out
						.println("Cheater? Only the big lebowski can do this!!!");
				return 0;
			}
		} else {
			return frameScore;
		}
	}
}
