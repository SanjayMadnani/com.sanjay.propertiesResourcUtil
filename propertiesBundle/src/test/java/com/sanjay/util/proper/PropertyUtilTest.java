/* Copyright (C) 2014, 2015 Sanjay Madnani
 * 
 * This file is free to use: you can redistribute it and/or modify it under the terms of the GPL General Public License
 * V2 as published by the Free Software Foundation, subject to the following conditions:
 * 
 * The above copyright notice should never be changed and should always included wherever this file is used.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY.
 * See the GNU General Public License V2 for more details. */
package com.sanjay.util.proper;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sanjay.constants.MessagesConstants;

/**
 * Test case for PropertyUtil.
 * 
 * @author SANJAY
 * @see PropertyUtil
 */
public class PropertyUtilTest {

    private PropertyUtil propertyUtil1;
    private PropertyUtil propertyUtil2;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        propertyUtil2 = new PropertyUtil(MessagesConstants.PROPERTY_FILE);
        propertyUtil1 = new PropertyUtil("src/main/resources", MessagesConstants.PROPERTY_FILE);
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        propertyUtil1 = null;
        propertyUtil2 = null;
    }

    /**
     * Test method for {@link com.sanjay.util.proper.PropertyUtil#getValue(java.lang.String)}.
     */
    @Test
    public final void testGetValue() {
        assertEquals("smtp.gmail.com", propertyUtil1.getValue("email.smpt.host"));
        assertEquals("smtp.yahoo.com", propertyUtil2.getValue("email.smpt.host"));
    }
}
