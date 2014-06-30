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
 * @author sanjay.madnani
 *
 */
public class BundleUtilTest {
    
    private BundleUtil bundleUtil;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        bundleUtil = new BundleUtil(MessagesConstants.BUNDLE_FILE);
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        bundleUtil = null;
    }

    /**
     * Test method for {@link com.sanjay.util.proper.BundleUtil#getStringMessage(java.lang.String)}.
     */
    @Test
    public final void testGetStringMessage() {
        assertEquals("MOBILE1000: Mobile Number is Invalid.", bundleUtil.getStringMessage(MessagesConstants.INVALID_MOBILE_NUMBER));
    }

    /**
     * Test method for {@link com.sanjay.util.proper.BundleUtil#getFormatedMessage(java.lang.String, java.lang.Object[])}.
     */
    @Test
    public final void testGetFormatedMessage() {
        String actualResult = bundleUtil.getFormatedMessage(MessagesConstants.REGISTRATION_SUCCESS, "user1", "454585");
        String expectedResult = "Dear user1, Your Registration Id is 454585.";
        assertEquals(expectedResult, actualResult);
    }

}
