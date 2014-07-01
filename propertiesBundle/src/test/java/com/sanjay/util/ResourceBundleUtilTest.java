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
        assertEquals("EMAIL1000: Email Id is Empty.", ResourceBundleUtil.getStringMessage(
                MessagesConstants.EMPTY_MAIL_ID, MessagesConstants.BUNDLE_FILE, null));
    }

    /**
     * Test method for
     * {@link com.sanjay.util.ResourceBundleUtil#getFormatedMessage(java.lang.String, java.lang.String, java.util.Locale, java.lang.Object[])}
     * .
     */
    @Test
    public final void testGetFormatedMessage() {
        String formatedMessage =
                ResourceBundleUtil.getFormatedMessage(MessagesConstants.REGISTRATION_SUCCESS,
                        MessagesConstants.BUNDLE_FILE, null, "Name1", "11001121");
        String expectedResult = "Dear Name1, Your Registration Id is 11001121.";
        assertEquals(expectedResult, formatedMessage);
    }

}
