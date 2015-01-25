package com.nabla.project.fronter;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * A role is on try (2 tries are a frame)
 * 
 */
public class DecodeFrameTest {

	@Test(expected = IllegalArgumentException.class)
	public final void testFrameSillyNumber() {
		DecodeFrame oneFrame = new DecodeFrame("0@");
		Assert.assertEquals(0, oneFrame.compute());
	}

	@Test
	public final void testRollNumberOnetry() {
		DecodeFrame oneFrame = new DecodeFrame("0");
		Assert.assertEquals(0, oneFrame.compute());

		oneFrame = new DecodeFrame("2");
		Assert.assertEquals(2, oneFrame.compute());

		oneFrame = new DecodeFrame("5");
		Assert.assertEquals(5, oneFrame.compute());

		oneFrame = new DecodeFrame("7");
		Assert.assertEquals(7, oneFrame.compute());

		oneFrame = new DecodeFrame("9");
		Assert.assertEquals(9, oneFrame.compute());
	}

	@Test
	public final void testRollNumberTwotry() {
		// Miss
		DecodeFrame oneFrame = new DecodeFrame("00");
		Assert.assertEquals(0, oneFrame.compute());
		// Nothing special
		oneFrame = new DecodeFrame("05");
		Assert.assertEquals(5, oneFrame.compute());
		oneFrame = new DecodeFrame("35");
		Assert.assertEquals(8, oneFrame.compute());
		oneFrame = new DecodeFrame("70");
		Assert.assertEquals(7, oneFrame.compute());
		// Spare
		oneFrame = new DecodeFrame("55");
		Assert.assertEquals(10, oneFrame.compute());
		oneFrame = new DecodeFrame("73");
		Assert.assertEquals(10, oneFrame.compute());
	}

	@Test
	public final void testRollSpare() {
		// Assert.assertEquals(new Integer(10), new
		// DecodeRolls("0/").compute());
		// Assert.assertEquals(new Integer(10), new
		// DecodeRolls("5/").compute());
		// Assert.assertEquals(new Integer(10), new
		// DecodeRolls("9/").compute());
		DecodeFrame oneFrame = new DecodeFrame("0/");
		Assert.assertEquals(10, oneFrame.compute());
	}

	@Test
	public final void testRollStrike() {
		DecodeFrame oneFrame = new DecodeFrame("X");
		Assert.assertEquals(10, oneFrame.compute());
	}

	@Test
	public final void testRollMiss() {
		DecodeFrame oneFrame = new DecodeFrame("-");
		Assert.assertEquals(0, oneFrame.compute());
	}
}
