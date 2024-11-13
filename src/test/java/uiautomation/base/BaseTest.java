package uiautomation.base;


import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import uiautomation.utils.LoggerManager;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.ResourceBundle;


public class BaseTest {
    public static RemoteWebDriver driver;
    public static LoggerManager logger;
    public static ResourceBundle Configuration;
    public static HashMap<String, Double> savedValues;

    @BeforeAll
    public static void setUpAll() {
        savedValues = new HashMap<>();
        logger = new LoggerManager();
    }

    @Given("Select Browser As {string}")
    public static void setUp(String browserName) {
        String browser = browserName.toUpperCase();
        switch (browser.toUpperCase()) {
            case "CHROME":
                driver = Drivers.CHROME.browserConfigureOptions();
                break;
            case "FIREFOX":
                driver = Drivers.FIREFOX.browserConfigureOptions();
                break;
            case "SAFARI":
                driver = Drivers.SAFARI.browserConfigureOptions();
                break;
        }
        driver.manage().window().maximize();
        logger.info("Selected browser is: " + browser);

    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Error Screen", new ByteArrayInputStream(screenshot));
        }
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

}
