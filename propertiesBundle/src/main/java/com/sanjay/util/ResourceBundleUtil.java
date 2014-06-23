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

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utility for getting i18n value from Properties file.
 * 
 * @author SANJAY
 * @see ResourceBundle
 * @see Locale
 * @see MessageFormat
 */
public final class ResourceBundleUtil {
    private static final Logger logger = LogManager.getLogger(ResourceBundleUtil.class);

    /**
     * Private Construct to restrict object creation.
     */
    private ResourceBundleUtil() {
    }

    /**
     * Gets a resource bundle using the specified base name and locale.
     * 
     * @param baseName - the base name of the resource bundle, a fully qualified class name.
     * @param locale - the locale for which a resource bundle is desired.
     * @exception NullPointerException - if baseName is null.
     * @exception MissingResourceException - if no resource bundle for the specified base name can be found.
     * @return a resource bundle for the given base name and locale.
     */
    private static ResourceBundle getResourceBundle(String baseName, Locale locale) {
        logger.debug("Invoking getResourceBundle: Loading Bundle...");
        ResourceBundle bundle = ResourceBundle.getBundle(baseName, (locale == null) ? Locale.getDefault() : locale);
        logger.debug("Resouce Bundle loaded successfully");
        return bundle;
    }

    /**
     * Gets a string for the given key from baseName resource bundle. {@link #getResourceBundle}.
     * 
     * @param key - the key for the desired string.
     * @param baseName - the base name of the resource bundle, a fully qualified class name.
     * @param locale - the locale for which a resource bundle is desired.
     * @exception NullPointerException if key is null.
     * @exception MissingResourceException if no object for the given key can be found.
     * @exception ClassCastException if the object found for the given key is not a string.
     * @return the string for the given key.
     */
    public static String getStringMessage(String key, String baseName, Locale locale) {
        logger.debug("Invoking getStringMessage...");
        try {
            ResourceBundle bundle = getResourceBundle(baseName, locale);
            logger.debug("Retrieved Key successfully");
            return bundle.getString(key);
        } catch (NullPointerException | MissingResourceException | ClassCastException ex) {
            logger.error(ex.getMessage(), ex);
            logger.debug("Exception occured while retrieving value corresponding to key", ex);
            return null;
        }
    }

    /**
     * Gets a string for the given key from baseName resource bundle and formats string with passed arguments.
     * {@link #getResourceBundle}.
     * 
     * @param key - the key for the desired string.
     * @param baseName - the base name of the resource bundle, a fully qualified class name.
     * @param locale - the locale for which a resource bundle is desired.
     * @param arguments - parameters for formatting string.
     * @exception NullPointerException if key is null.
     * @exception MissingResourceException if no object for the given key can be found.
     * @exception ClassCastException if the object found for the given key is not a string.
     * @exception IllegalArgumentException if the value of key is invalid, or if an argument in the arguments array is
     *                not of the type expected by the format element(s) that use it.
     * @return the string for the given key.
     */
    public static String getFormatedMessage(String key, String baseName, Locale locale, Object... arguments) {
        logger.debug("Invoking getFormatedMessage...");
        try {
            ResourceBundle bundle = getResourceBundle(baseName, locale);
            return MessageFormat.format(bundle.getString(key), arguments);
        } catch (NullPointerException | MissingResourceException | ClassCastException ex) {
            logger.error(ex.getMessage(), ex);
            logger.debug("Exception occured while retrieving and formatting value corresponding to key", ex);
            return null;
        }
    }
}
