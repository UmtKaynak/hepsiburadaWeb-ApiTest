package uiautomation.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import uiautomation.steps.BaseSteps;
import uiautomation.utils.LoggerManager;


public class CommonStepDefinitions {
    LoggerManager logger = new LoggerManager();
    BaseSteps baseSteps = new BaseSteps();

    @Given("User get {string} address")
    public void driverSet(String url) {
        logger.info("Entered.");
        baseSteps.getUrl(url);

    }

    @And("User focuses on tab {int}")
    public void userFocusesTabByIndex(int tabIndex) {
        logger.info("Entered.");
        baseSteps.focusTabWithNumber(tabIndex);
    }

    @And("User can displayed {string} on the {string} page")
    public void userCanDisplayedOnThePage(String elementName, String pageName) {
        logger.info("Entered.");
        baseSteps.isDiplayedClickElement(elementName, pageName);
    }
}
