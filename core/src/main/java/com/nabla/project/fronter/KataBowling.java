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

import java.io.Serializable;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.nabla.project.fronter.api.IGame;

@Immutable
public class KataBowling implements IGame, Comparable<KataBowling>, Serializable
{

    private static final long  serialVersionUID      = 1L;

    public static final String DEFAULT_NAME          = "KataBowling";

    private final String       name                  = KataBowling.DEFAULT_NAME; // NOSONAR

    public static final int    DEFAULT_FRAMES_NUMBER = 10;
    public static final int    DEFAULT_PINS_NUMBER   = 10;
    public static final int    DEFAULT_TRIES_NUMBER  = 2;

    @Nonnull
    // @Pattern(regexp="(\\d\\/)+\\d", message="Invalid rolls!")
    private final String       rolls;

    private int                score                 = 0;

    public KataBowling()
    {
        throw new AssertionError();
    }

    public KataBowling(@Nonnull final String aRolls)
    {

        this.rolls = aRolls;
        this.validateState();

    }

    /**
     * Validate immutable data like String.
     * It raise the exception IllegalArgumentException when arguments are wrong
     */
    private void validateState()
    {
        if (null == this.rolls) // NOPMD
        {
            throw new IllegalArgumentException("Rolls cannot be null");
        }
        // TODO more validation
    }

    @Override
    public String getRolls()
    {
        return this.rolls;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public int getScore()
    {
        return new DecodeFrame(this.getRolls()).compute();
    }

    @Override
    public final String toString()
    {

        final StringBuilder str = new StringBuilder();

        str.append("name:").append(this.getName()).append(' ');
        str.append("rolls:").append(this.getRolls()).append(' ');
        str.append("score:").append(this.getScore());

        return str.toString();

    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(17, 31). // two randomly chosen prime numbers
                // if deriving: appendSuper(super.hashCode()).
                append(this.getName()).append(this.getScore()).toHashCode();
    }

    @Override
    public boolean equals(final Object obj)
    {
        if (null == obj) // NOPMD
        {
            return false;
        }
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof KataBowling))
        {
            return false;
        }

        final KataBowling rhs = (KataBowling) obj;
        return new EqualsBuilder().
        // if deriving: appendSuper(super.equals(obj)).
                append(this.name, rhs.name).append(this.score, rhs.score).isEquals();
    }

    @Override
    public int compareTo(final KataBowling aGame)
    {
        if (this == aGame)
        {
            return 0;
        }

        // the object fields are never null
        final int comparison = new Integer(this.score).compareTo(aGame.score);
        if (comparison != 0) // NOPMD
        {
            return comparison;
        }

        return 0;
    }

}
