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

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
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
     * @param path String directory of property.
     * @param propertyName String property name.
     * @return Properties loaded using argument.
     */
    private static Properties loadProperty(String path, String propertyName) {
        logger.debug("Invoking loadProperty with propertyName: " + propertyName + "...");
        try {
            Properties properties = new Properties();
            if (path == null) {
                InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(propertyName);
                properties.load(is);
                logger.debug("Property Loaded successfully");
            } else {
                logger.debug("Property Path: " + path);
                Reader reader = new FileReader(new File(path, propertyName));
                properties.load(reader);
                logger.debug("Property Loaded successfully");
            }
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
    public static Object getValue(String key, String propertyName) {
        logger.debug("Invoking getValue...");
        Properties properties = loadProperty(null, propertyName);
        return properties.get(key);
    }

    /**
     * Returns key value corresponding to properyName by specified directory.
     * 
     * @param key the key whose associated value is to be returned.
     * @param propertyDir directory path of property.
     * @param propertyName String name of property.
     * @return object value of a key defined in property.
     */
    public static Object getValue(String key, String propertyDir, String propertyName) {
        logger.debug("Invoking getValue for key: " + key + ", directory: " + propertyDir + ", Property Name: " +
                propertyName + "...");
        Properties properties = loadProperty(propertyDir, propertyName);
        return properties.get(key);
    }

}
