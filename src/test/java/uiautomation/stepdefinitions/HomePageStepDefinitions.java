package uiautomation.stepdefinitions;

import io.cucumber.java.en.And;
import uiautomation.steps.HomePageSteps;
import uiautomation.utils.LoggerManager;

public class HomePageStepDefinitions {
    LoggerManager logger = new LoggerManager();
    HomePageSteps homeSteps = new HomePageSteps();

    @And("User hover the {string} menu and selects {string} category and click {string} sub category")
    public void userHoverTheMenuAndSelectsCategoryAndClickSubCategory(String menuItem, String categoryName, String subCategoryName) {
        logger.info("Entered.");
        homeSteps.selectCategoryAndSubCategory(menuItem, categoryName, subCategoryName);
    }
}
