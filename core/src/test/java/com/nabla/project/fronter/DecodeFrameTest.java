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
		
		// Cheater below!!!
		oneFrame = new DecodeFrame("77");
		Assert.assertEquals(0, oneFrame.compute());
		oneFrame = new DecodeFrame("74");
		Assert.assertEquals(0, oneFrame.compute());		
		oneFrame = new DecodeFrame("99");
		Assert.assertEquals(0, oneFrame.compute());			
	}

	@Test
	public final void testRollSpare() {
		DecodeFrame oneFrame = new DecodeFrame("0/");
		Assert.assertEquals(10, oneFrame.compute());
		oneFrame = new DecodeFrame("/");
		Assert.assertEquals(10, oneFrame.compute());
		oneFrame = new DecodeFrame("4/");
		Assert.assertEquals(10, oneFrame.compute());
		oneFrame = new DecodeFrame("6/");
		Assert.assertEquals(10, oneFrame.compute());
		oneFrame = new DecodeFrame("9/");
		Assert.assertEquals(10, oneFrame.compute());		
	}

	@Test
	public final void testRollDoubleSpare() {
		DecodeFrame oneFrame = new DecodeFrame("//"); // Like 0/0/
		Assert.assertEquals((10 + 0) + 10, oneFrame.compute());		
		
		oneFrame = new DecodeFrame("2/0/");
		Assert.assertEquals((10 + 0) + 10, oneFrame.compute());
		
		oneFrame = new DecodeFrame("2//"); // Like 2/0/
		Assert.assertEquals((10 + 0) + 10, oneFrame.compute());
		
		oneFrame = new DecodeFrame("5/6/");
		Assert.assertEquals((10 + 6) + 10, oneFrame.compute());		
		
		oneFrame = new DecodeFrame("5/62");
		Assert.assertEquals((10 + 6) + (6 + 2), oneFrame.compute());
		
		oneFrame = new DecodeFrame("5/6"); //Not finished
		Assert.assertEquals((10 + 6) + 6, oneFrame.compute());	
	}
	
	@Test
	public final void testRollTripleSpare() {
		DecodeFrame oneFrame = new DecodeFrame("///");
		Assert.assertEquals((10 + 0) + (10 + 0) + 10, oneFrame.compute());
		
		oneFrame = new DecodeFrame("2/0//");
		Assert.assertEquals((10 + 0) + (10 + 0) + (10 + 0), oneFrame.compute());
		
		oneFrame = new DecodeFrame("5/6/0/");
		Assert.assertEquals((10 + 6) + (10 + 0) + 10, oneFrame.compute());		
	}
	
	@Test
	public final void testRollStrike() {
		DecodeFrame oneFrame = new DecodeFrame("X");
		Assert.assertEquals(10, oneFrame.compute());
	}

	@Test
	public final void testRollDoubleStrike() {
		DecodeFrame oneFrame = new DecodeFrame("XX");
		Assert.assertEquals((10 +10) + 10, oneFrame.compute());
	}
	
	@Test
	public final void testRollTripleStrike() {
		DecodeFrame oneFrame = new DecodeFrame("XXX");
		Assert.assertEquals((10 + 20) + (10 + 10) + 10, oneFrame.compute());
	}	
	
	@Test
	public final void testRollSpareAndStrike() {
		DecodeFrame oneFrame = new DecodeFrame("/X/8"); // Same as 0/X0/8
		Assert.assertEquals((10 + 10) + (10 + 0 + 8) + (10 + 8) + 8, oneFrame.compute());
		
		oneFrame = new DecodeFrame("2/X0/");
		Assert.assertEquals((10 + 10) + (10 + 0) + (10), oneFrame.compute());
		
		oneFrame = new DecodeFrame("2/X0/5");
		Assert.assertEquals((10 + 10) + (10 + 0 + 5) + (10 + 5) + 5, oneFrame.compute());
		
		oneFrame = new DecodeFrame("5/X0/");
		Assert.assertEquals((10 + 10) + (10 + 0) + 10, oneFrame.compute());		
	}
	
	@Test
	public final void testRollMiss() {
		DecodeFrame oneFrame = new DecodeFrame("-");
		Assert.assertEquals(0, oneFrame.compute());
	}
	
	@Test
	public final void testRollDoubleMiss() {
		DecodeFrame oneFrame = new DecodeFrame("--");
		Assert.assertEquals(0, oneFrame.compute());
	}	
}
