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
public final class BundleUtil {
    private static final Logger logger = LogManager.getLogger(BundleUtil.class);

    private transient String resourceBundleName;
    private transient ResourceBundle resourceBundle;
    private transient Locale bundleLocale;

    /**
     * 
     * @param resourceBundleName
     */
    public BundleUtil(final String resourceBundleName) {
        try {
            this.resourceBundleName = resourceBundleName;
            this.bundleLocale = Locale.getDefault();
            this.resourceBundle = ResourceBundle.getBundle(resourceBundleName);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 
     * @param resourceBundleName
     * @param locale
     */
    public BundleUtil(final String resourceBundleName, final Locale locale) {
        this.resourceBundleName = resourceBundleName;
        this.bundleLocale = locale;
        this.resourceBundle = ResourceBundle.getBundle(resourceBundleName, locale);
    }

    /**
     * 
     * @param key
     * @return
     */
    public String getStringMessage(final String key) {
        logger.debug("Invoking getStringMessage...");
        try {
            return this.resourceBundle.getString(key);
        } catch (NullPointerException | MissingResourceException | ClassCastException ex) {
            logger.error(ex.getMessage(), ex);
            return null;
        }
    }

    /**
     * 
     * @param key
     * @param arguments
     * @return
     */
    public String getFormatedMessage(final String key, final Object... arguments) {
        logger.debug("Invoking getFormatedMessage...");
        try {
            return MessageFormat.format(this.resourceBundle.getString(key), arguments);
        } catch (NullPointerException | MissingResourceException | ClassCastException | IllegalArgumentException ex) {
            logger.error(ex.getMessage(), ex);
            return null;
        }
    }
}
