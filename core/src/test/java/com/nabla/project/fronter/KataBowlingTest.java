/*
 * Copyright (c) 2002-2004, Nabla
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Nabla' nor 'Alban' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package com.nabla.project.fronter;

import org.junit.Assert;
import org.junit.Test;

import com.nabla.project.fronter.api.IGame;

/**
 * DOCUMENT ME!
 * 
 * @author $Author$
 * @version $Revision$
 * @since $Date$
 */
public class KataBowlingTest
{
    
    public static final int DEFAULT_SCORE = 0;
    public static final String TEST_CASE1_ROLLS = new String("XXXXXXXXXXXX");
    public static final String TEST_CASE2_ROLLS = new String("9-9-9-9-9-9-9-9-9-9-");
    public static final String TEST_CASE3_ROLLS = new String("5/5/5/5/5/5/5/5/5/5/5");
    
    public static final int TEST_CASE1_ROLLS_EXPECTED_SCORE = 300;
    public static final int TEST_CASE2_ROLLS_EXPECTED_SCORE = 90;    
    public static final int TEST_CASE3_ROLLS_EXPECTED_SCORE = 150;    
    
    @Test(expected = AssertionError.class)
    public final void testEmptyContructor()
    {

        final IGame game = new KataBowling();
        Assert.assertNotNull(game);

    }

    @Test(expected = IllegalArgumentException.class)
    public final void testRollsNull()
    {

        @SuppressWarnings("null")
        final IGame game = new KataBowling(null);
        Assert.assertNotNull(game);

    }

    @Test
    public final void testRollsContructor()
    {

        Assert.assertFalse(new Integer(new KataBowling(KataBowlingTest.TEST_CASE1_ROLLS).getScore()).equals(KataBowlingTest.DEFAULT_SCORE));
        Assert.assertEquals(KataBowlingTest.TEST_CASE1_ROLLS_EXPECTED_SCORE, new KataBowling(KataBowlingTest.TEST_CASE1_ROLLS).getScore());
    }

    @Test
    public final void testToString()
    {

        Assert.assertFalse(new KataBowling(KataBowlingTest.TEST_CASE1_ROLLS).equals("name:" + KataBowling.DEFAULT_NAME + " rolls:" + KataBowlingTest.TEST_CASE1_ROLLS + " score:" + KataBowlingTest.DEFAULT_SCORE));
        Assert.assertEquals("name:" + KataBowling.DEFAULT_NAME + " rolls:" + KataBowlingTest.TEST_CASE1_ROLLS + " score:" + KataBowlingTest.TEST_CASE1_ROLLS_EXPECTED_SCORE, new KataBowling(KataBowlingTest.TEST_CASE1_ROLLS).toString());

    }

    @Test
    public final void testCase1()
    {
        Assert.assertEquals(KataBowlingTest.TEST_CASE1_ROLLS_EXPECTED_SCORE, new KataBowling(KataBowlingTest.TEST_CASE1_ROLLS).getScore());
    }

    @Test
    public final void testCase2()
    {
        Assert.assertEquals(KataBowlingTest.TEST_CASE2_ROLLS_EXPECTED_SCORE, new KataBowling(KataBowlingTest.TEST_CASE2_ROLLS).getScore());
    }

    @Test
    public final void testCase3()
    {

        Assert.assertEquals(KataBowlingTest.TEST_CASE3_ROLLS_EXPECTED_SCORE, new KataBowling(KataBowlingTest.TEST_CASE3_ROLLS).getScore());
    }
    
    //TODO Not required
    @Test(expected = IllegalArgumentException.class)
    public final void testSillyRollsContructor()
    {

    	IGame game = new KataBowling("ABC");    	
        Assert.assertEquals(0, game.getScore());
    }

}
