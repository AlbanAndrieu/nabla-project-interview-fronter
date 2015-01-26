package com.nabla.project.fronter;

import org.junit.Assert;
import org.junit.Test;

/**
 * A role is on try (2 tries are a frame)
 */
public class DecodeRollTest
{

    @Test(expected = IllegalArgumentException.class)
    public final void testRollSillyNumber()
    {
        DecodeRoll oneRoll = new DecodeRoll('@');
        Assert.assertEquals(0, oneRoll.compute());
    }

    @Test
    public final void testRollNumberOnetry()
    {
        DecodeRoll oneRoll = new DecodeRoll('0');
        Assert.assertEquals(0, oneRoll.compute());
        Assert.assertEquals(false, oneRoll.isMiss());
        Assert.assertEquals(false, oneRoll.isSpare());
        Assert.assertEquals(false, oneRoll.isStrike());
        Assert.assertEquals(false, oneRoll.isFrameComplete());

        oneRoll = new DecodeRoll('2');
        Assert.assertEquals(2, oneRoll.compute());
        Assert.assertEquals(false, oneRoll.isMiss());
        Assert.assertEquals(false, oneRoll.isSpare());
        Assert.assertEquals(false, oneRoll.isStrike());
        Assert.assertEquals(false, oneRoll.isFrameComplete());

        oneRoll = new DecodeRoll('5');
        Assert.assertEquals(5, oneRoll.compute());
        Assert.assertEquals(false, oneRoll.isMiss());
        Assert.assertEquals(false, oneRoll.isSpare());
        Assert.assertEquals(false, oneRoll.isStrike());
        Assert.assertEquals(false, oneRoll.isFrameComplete());

        oneRoll = new DecodeRoll('7');
        Assert.assertEquals(7, oneRoll.compute());
        Assert.assertEquals(false, oneRoll.isMiss());
        Assert.assertEquals(false, oneRoll.isSpare());
        Assert.assertEquals(false, oneRoll.isStrike());
        Assert.assertEquals(false, oneRoll.isFrameComplete());

        oneRoll = new DecodeRoll('9');
        Assert.assertEquals(9, oneRoll.compute());
        Assert.assertEquals(false, oneRoll.isMiss());
        Assert.assertEquals(false, oneRoll.isSpare());
        Assert.assertEquals(false, oneRoll.isStrike());
        Assert.assertEquals(false, oneRoll.isFrameComplete());
    }

    /*
     * @Test
     * public final void testRollNumberTwotry()
     * {
     * //Miss
     * Assert.assertEquals(new Integer(0), new DecodeRolls("00").compute());
     * //Nothing special
     * Assert.assertEquals(new Integer(5), new DecodeRolls("05").compute());
     * Assert.assertEquals(new Integer(7), new DecodeRolls("70").compute());
     * //Spare
     * Assert.assertEquals(new Integer(10), new DecodeRolls("55").compute());
     * }
     */

    @Test
    public final void testRollSpare()
    {
        // Assert.assertEquals(new Integer(10), new DecodeRolls("0/").compute());
        // Assert.assertEquals(new Integer(10), new DecodeRolls("5/").compute());
        // Assert.assertEquals(new Integer(10), new DecodeRolls("9/").compute());
        DecodeRoll aRoll = new DecodeRoll('/');
        Assert.assertEquals(10, aRoll.compute());
        Assert.assertEquals(false, aRoll.isMiss());
        Assert.assertEquals(true, aRoll.isSpare());
        Assert.assertEquals(false, aRoll.isStrike());
        Assert.assertEquals(true, aRoll.isFrameComplete());
    }

    @Test
    public final void testRollStrike()
    {
        DecodeRoll aRoll = new DecodeRoll('X');
        Assert.assertEquals(10, aRoll.compute());
        Assert.assertEquals(false, aRoll.isMiss());
        Assert.assertEquals(false, aRoll.isSpare());
        Assert.assertEquals(true, aRoll.isStrike());
        Assert.assertEquals(true, aRoll.isFrameComplete());
    }

    @Test
    public final void testRollMiss()
    {
        DecodeRoll aRoll = new DecodeRoll('-');
        Assert.assertEquals(0, aRoll.compute());
        Assert.assertEquals(true, aRoll.isMiss());
        Assert.assertEquals(false, aRoll.isSpare());
        Assert.assertEquals(false, aRoll.isStrike());
        Assert.assertEquals(true, aRoll.isFrameComplete());
    }
}
