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

import org.junit.Test;

import com.sanjay.constants.MessagesConstants;

/**
 * Test case for PropertyUtil.
 * 
 * @author SANJAY
 * @see PropertyUtil
 */
public class PropertyUtilTest {
    /**
     * Test method for {@link com.sanjay.util.PropertyUtil#getValue(java.lang.String, java.lang.String)}.
     */
    @Test
    public final void testGetValue() {
        assertEquals("root1", (String) PropertyUtil.getValue("db.password", MessagesConstants.PROPERTY_FILE));
        assertEquals("root",
                (String) PropertyUtil.getValue("db.password", "src/main/resources", MessagesConstants.PROPERTY_FILE));
    }

}
