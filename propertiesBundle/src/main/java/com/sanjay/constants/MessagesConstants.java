/* Copyright (C) 2014, 2015 Sanjay Madnani
 * 
 * This file is free to use: you can redistribute it and/or modify it under the terms of the GPL General Public License
 * V2 as published by the Free Software Foundation, subject to the following conditions:
 * 
 * The above copyright notice should never be changed and should always included wherever this file is used.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY.
 * See the GNU General Public License V2 for more details. */
package com.sanjay.constants;

/**
 * Keeps all constants for resource bundle.
 * 
 * @author SANJAY
 * @see common-messages.properties
 */
public final class MessagesConstants {

    /**
     * Private Construct to restrict object creation.
     */
    private MessagesConstants() {

    }

    public static final String PROPERTY_FILE = "common-settings.properties";
    public static final String BUNDLE_FILE = "common-messages";

    public static final String EMPTY_MAIL_ID = "ERROR.EMAIL.1000";
    public static final String INVALID_EMAIL_ID = "ERROR.EMAIL.1001";
    public static final String INVALID_MOBILE_NUMBER = "ERROR.MOBILE.1000";
    public static final String REGISTRATION_SUCCESS = "ACK.SUCCESS.1000";

}
