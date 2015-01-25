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

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.nabla.project.fronter.KataBowling;
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
    public static final String DEFAULT_TEST_ROLLS = new String("XXXXXXXXXXXX");
    public static final int DEFAULT_TEST_EXPECTED_SCORE = 300;    
    
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

        Assert.assertFalse(new Integer(new KataBowling(KataBowlingTest.DEFAULT_TEST_ROLLS).getScore()).equals(KataBowlingTest.DEFAULT_SCORE));
        Assert.assertEquals(KataBowlingTest.DEFAULT_TEST_EXPECTED_SCORE, new KataBowling(KataBowlingTest.DEFAULT_TEST_ROLLS).getScore());
    }

    @Test
    public final void testToString()
    {

        Assert.assertFalse(new KataBowling(KataBowlingTest.DEFAULT_TEST_ROLLS).equals("name:" + KataBowling.DEFAULT_NAME + " rolls:" + KataBowlingTest.DEFAULT_TEST_ROLLS + " score:" + KataBowlingTest.DEFAULT_SCORE));
        Assert.assertEquals("name:" + KataBowling.DEFAULT_NAME + " rolls:" + KataBowlingTest.DEFAULT_TEST_ROLLS + " score:" + KataBowlingTest.DEFAULT_TEST_EXPECTED_SCORE, new KataBowling(KataBowlingTest.DEFAULT_TEST_ROLLS).toString());

    }

    //TODO Not required
    @Test(expected = IllegalArgumentException.class)
    public final void testSillyRollsContructor()
    {

        Assert.assertEquals(null, new KataBowling("ABC"));
    }

}
