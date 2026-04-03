/*
 * Copyright (c) 2022 Anh Tester
 * Automation Framework Selenium
 */

package com.anhtester.utils;

import org.testng.Reporter;
import org.testng.ITestResult;
import org.testng.xml.XmlTest;

import static com.anhtester.constants.FrameworkConstants.BROWSER;

public final class BrowserInfoUtils {

    private BrowserInfoUtils() {
        super();
    }

    private static final String OS = System.getProperty("os.name").toLowerCase();

    public static String getBrowserInfo() {
        ITestResult currentTestResult = Reporter.getCurrentTestResult();
        if (currentTestResult == null || currentTestResult.getTestContext() == null) {
            return BROWSER.toUpperCase();
        }

        XmlTest currentXmlTest = currentTestResult.getTestContext().getCurrentXmlTest();
        if (currentXmlTest == null) {
            return BROWSER.toUpperCase();
        }

        String configuredBrowser = currentXmlTest.getParameter("BROWSER");
        if (configuredBrowser == null || configuredBrowser.trim().isEmpty()) {
            return BROWSER.toUpperCase();
        }

        return configuredBrowser.trim().toUpperCase();
    }

    public static String getOSInfo() {
        return System.getProperty("os.name");
    }

    public static boolean isWindows() {
        return (OS.contains("win"));
    }

    public static boolean isMac() {
        return (OS.contains("mac"));
    }

    public static boolean isUnix() {
        return (OS.contains("nix") || OS.contains("nux") || OS.contains("aix"));
    }

    public static boolean isSolaris() {
        return (OS.contains("sunos"));
    }

}
