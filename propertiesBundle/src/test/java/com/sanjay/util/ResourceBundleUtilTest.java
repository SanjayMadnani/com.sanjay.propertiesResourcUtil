/* Copyright (C) 2014, 2015 Sanjay Madnani
 * 
 * This file is free to use: you can redistribute it and/or modify it under the terms of the GPL General Public License
 * V2 as published by the Free Software Foundation, subject to the following conditions:
 * 
 * The above copyright notice should never be changed and should always included wherever this file is used.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY.
 * See the GNU General Public License V2 for more details. */
package com.sanjay.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Test case for ResourceBundleUtil.
 * 
 * @author sanjay.madnani
 * @see ResourceBundleUtil
 */
public class ResourceBundleUtilTest {

    /**
     * Test method for
     * {@link com.sanjay.util.ResourceBundleUtil#getString(java.lang.String, java.lang.String, java.util.Locale)}.
     */
    @Test
    public final void testGetString() {
        assertEquals("hello", ResourceBundleUtil.getStringMessage("hi", "log-Config", null));
    }

    /**
     * Test method for
     * {@link com.sanjay.util.ResourceBundleUtil#getFormatedMessage(java.lang.String, java.lang.String, java.util.Locale, java.lang.Object[])}
     * .
     */
    @Test
    public final void testGetFormatedMessage() {
        fail("Not yet implemented");
    }

}
