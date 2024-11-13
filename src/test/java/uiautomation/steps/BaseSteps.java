package uiautomation.steps;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uiautomation.base.BaseTest;
import uiautomation.utils.LoggerManager;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static uiautomation.utils.PageElementFinder.getElement;


public class BaseSteps {
    protected WebDriver driver;
    protected LoggerManager logger;
    protected HashMap<String, Double> savedValues;


    public BaseSteps() {
        this.driver = BaseTest.driver;
        this.logger = BaseTest.logger;
        this.savedValues = BaseTest.savedValues;
    }

    public void getUrl(String url) {
        logger.info("Entered");
        driver.get(url);
        String actualUrl = getCurrentUrl();
        Assertions.assertEquals(url, actualUrl, "Current Url is not correct");
        logger.info("URL navigation successful. Current URL is correct.");
    }


    public String getCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        logger.info("Current URL: " + currentUrl);
        return currentUrl;
    }


    public By returnWebElementByUsingPageNameElementName(String pageName, String elementName) {
        logger.info(elementName + "Element is returned on the" + pageName);
        return getElement(pageName, elementName);
    }

    public WebElement findElement(By key) {
        logger.info("Entered.");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(key));
        logger.info("Element located by " + key + " found.");
        WebElement element = driver.findElement(key);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})", element);
        return element;
    }

    public WebElement findElement(String pageName, String elementName) {
        return findElement(returnWebElementByUsingPageNameElementName(pageName, elementName));
    }

    public List<WebElement> findElements(By by) {
        logger.info("Entered.");
        List<WebElement> elementList = driver.findElements(by);
        logger.info("Element List created size=" + elementList.size());
        return elementList;
    }

    public void hoverElement(By key) {
        logger.info("Hovering over the " + key + " element.");
        WebElement element = findElement(key);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        logger.info("Cursor is on the " + key + " element");
    }

    public void clickElement(By by) {
        logger.info("Entered.");
        findElement(by).click();
    }

    public void clickElement(WebElement element) {
        logger.info("Entered.");
        element.click();
    }

    public void clickByJs(WebElement webElement) {
        logger.info("Entered.");
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});", webElement);
        executor.executeScript("arguments[0].click();", webElement);
        logger.info("Element is clicked by Js");

    }

    public void isDiplayedClickElement(String elementName, String pageName) {
        logger.info("Entered.");
        WebElement element = findElement(pageName, elementName);
        if (element.isDisplayed())
            clickElement(element);
        else
            logger.error(elementName + " Element is not displayed");
    }

    public void sendText(By by, String text) {
        logger.info("Entered.");
        findElement(by).sendKeys(text);
        logger.info("Sended text is " + text);
    }


    public void sendText(String pageName, String elementName, String text) {
        logger.info("Entered.");
        findElement(pageName, elementName).sendKeys(text);
    }

    public String getText(By by) {
        logger.info("Entered.");
        String elementText = findElement(by).getText();
        return elementText;
    }

    public String getText(String pageName, String elementName) {
        logger.info("Entered.");
        String elementText = findElement(pageName, elementName).getText();
        return elementText;
    }

    public String getText(WebElement element) {
        logger.info("Entered.");
        String elementText = element.getText();
        return elementText;
    }


    public void scrollElement(By key) {
        logger.info("Entered.");
        scrollElement(findElement(key));
    }

    public void scrollElement(WebElement element) {
        logger.info("Scrolling to the " + element + " element.");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        logger.info("Scrolling completed.");
    }

    public void scrollElement(String pageName, String elementName) {
        logger.info("Entered.");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", findElement(pageName, elementName));
        logger.info("Scrolling completed.");
    }

    public void waitByMilliSeconds(long milliseconds) {
        logger.info("Waiting for " + milliseconds + " milliseconds");
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public By createXPathByText(String startWith, String text, String endWith) {
        logger.info("Creating XPath with text: " + text);
        By elementPath;
        if (startWith == null && endWith == null) {
            elementPath = By.xpath("//*[text()='" + text + "']");
        } else if (startWith == null) {
            elementPath = By.xpath("//*" + "[text()='" + text + "']" + endWith);
        } else if (endWith == null) {
            elementPath = By.xpath(startWith + "[text()='" + text + "']");
        } else {
            elementPath = By.xpath(startWith + "[text()='" + text + "']" + endWith);
        }
        logger.info(" XPath is created: " + elementPath);
        return elementPath;
    }

    public String getElementAttributeValue(WebElement element, String attribute) {
        logger.info("Entered.");
        String attributeValue = element.getAttribute(attribute);
        logger.info("Attribute value retrieved: " + attributeValue);
        return attributeValue;
    }

    public double convertStringToDouble(String text) {
        logger.info("Entered.");
        text = text.replaceAll("[^0-9,.]+", "");
        String doubleForm = text.replace(".", "").replace(",", ".");
        logger.info("Converted double is " + doubleForm);
        return Double.parseDouble(doubleForm);
    }

    public void focusTabWithNumber(int number) {
        logger.info("Entered. Parameters  TabNumber : " + number);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(number - 1));
    }

    public void comparePrices(By newPriceText) {
        double expectedPrice = savedValues.get("ProductListPagePrice");
        double actualPrice = convertStringToDouble(getText(newPriceText));
        Assertions.assertEquals(actualPrice, expectedPrice, "Prices are not equals on the last page");
    }

    public void refreshPage() {
        logger.info("Entered.");
        driver.navigate().refresh();
    }

}
