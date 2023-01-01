package com.epam.tc.hw6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverFactory {

    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";

    public static WebDriver getWebDriver(boolean isLocal, String browser, String hub) {
        if (isLocal) {
            return WebDriverManager.getInstance(browser).create();
        } else {
            Capabilities capabilities = getCapabilities(browser);
            return new RemoteWebDriver(getUrl(hub), capabilities);
        }
    }

    private static URL getUrl(String hub) {
        try {
            return new URL(hub);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Hub URL is malformed", e);
        }
    }

    private static Capabilities getCapabilities(String browser) {
        switch (browser) {
            case CHROME:
                return new ChromeOptions();
            case FIREFOX:
                return new FirefoxOptions();
            default:
                throw new WebDriverManagerException(String.format("The browser name '%s' is not recognized", browser));
        }
    }
}
