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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utility for Loading & Retrieving Properties values.
 * 
 * @author SANJAY
 * @see Properties
 * @see MessageFormat
 */
public final class PropertyUtil {

    private static final Logger logger = LogManager.getLogger(PropertyUtil.class);
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
        logger.debug("Invoking loadProperty...");
        try {
            Properties properties = new Properties();
            Reader reader = new FileReader(propertyName);
            properties.load(reader);
            return properties;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * Returns key value corresponding to properyName.
     * 
     * @param key the key whose associated value is to be returned.
     * @param propertyName String property name.
     * @return value corresponding to key by passed property.
     */
    public static Object getValue(String key, String properyName) {
        logger.debug("Invoking getValue...");
        Properties properties = loadProperty(properyName);
        return properties.get(key);
    }

    /**
     * Returns formated String value corresponding to key of propertyName.
     * 
     * @param key the key whose associated value is to be returned.
     * @param properyName String name of property.
     * @param arguments - parameters for formatting string.
     * @return formated string for the given key.
     */
    public static String getFormatedStringValue(String key, String properyName, Object... arguments) {
        logger.debug("Invoking getFormatedStringValue...");
        Properties properties = loadProperty(properyName);
        return MessageFormat.format(properties.getProperty(key), arguments);
    }
}
