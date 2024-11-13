package uiautomation.base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public enum Drivers {

    /**
     * this class is created as an enum, and it works by setting and returning the browser according to the invoked browser.
     *
     *
     */


    CHROME {
        @Override
        public RemoteWebDriver browserConfigureOptions() {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("useAutomationExtension", false);
            chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            chromeOptions.addArguments("--lang=tr");
            chromeOptions.addArguments("--disable-popup-blocking", "--disable-gpu", "--no-sandbox", "disable-infobars",
                    "disable-plugins", "ignore-certificate-errors", "disable-translate", "disable-extensions", "--disable-notifications", "--remote-allow-origins=*");
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("credentials_enable_service", false);
            parameters.put("password_manager_enabled", false);
            chromeOptions.setCapability("key", System.getProperty("key"));
            chromeOptions.setExperimentalOption("prefs", parameters);
            return new ChromeDriver(chromeOptions);
        }
    },
    FIREFOX {
        @Override
        public RemoteWebDriver browserConfigureOptions() {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setCapability("marionette", true);
            firefoxOptions.addPreference("dom.disable_beforeunload", true);
            firefoxOptions.addPreference("dom.popup_maximum", 0);
            return new FirefoxDriver(firefoxOptions);
        }
    },

    SAFARI {
        @Override
        public RemoteWebDriver browserConfigureOptions() {
            SafariOptions safariOptions = new SafariOptions();
            safariOptions.setCapability("safari:automaticInspection", true);
            safariOptions.setCapability("safari:automaticProfiling", true);
            return new SafariDriver(safariOptions);
        }
    };

    public abstract RemoteWebDriver browserConfigureOptions();

}


