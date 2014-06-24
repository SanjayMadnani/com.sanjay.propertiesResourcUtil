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

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * Utility for Loading & Retrieving Properties values.
 * 
 * @author SANJAY
 * @see Properties
 * @see MessageFormat
 */
public final class PropertyUtil {

    /**
     * Private Construct to restrict object creation.
     */
    private PropertyUtil() {
    }

    /**
     * Loads a property by propertyName.
     * 
     * @param propertyName String property name.
     * @return Properties loaded using argument.
     */
    private static Properties loadProperty(String propertyName) {
        try {
            Properties properties = new Properties();
            Reader reader = new FileReader(propertyName);
            properties.load(reader);
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Returns Object value corresponding to properyName.
     * @param key the key whose associated value is to be returned.
     * @param properyName
     * @return
     */
    public static Object getValue(String key, String properyName) {
        Properties properties = loadProperty(properyName);
        return properties.get(key);
    }

    /**
     * 
     * @param key the key whose associated value is to be returned.
     * @param property
     * @param arguments
     * @return
     */
    public static String getFormatedStringValue(String key, String property, Object... arguments) {
        Properties properties = loadProperty(property);
        return MessageFormat.format(properties.getProperty(key), arguments);
    }
}
