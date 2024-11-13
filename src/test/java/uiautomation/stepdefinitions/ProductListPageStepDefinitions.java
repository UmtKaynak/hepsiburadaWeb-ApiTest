package uiautomation.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import uiautomation.steps.productlistpage.ProductListPageFilterSteps;
import uiautomation.steps.productlistpage.ProductListPagePriceProcessSteps;
import uiautomation.utils.LoggerManager;

public class ProductListPageStepDefinitions {
    LoggerManager logger = new LoggerManager();
    ProductListPageFilterSteps productListPageSteps = new ProductListPageFilterSteps();
    ProductListPagePriceProcessSteps productListPagePriceProcessSteps = new ProductListPagePriceProcessSteps();

    @When("User applies filters on product list")
    public void userAppliesFiltersOnProductList(DataTable dataTable) {
        logger.info("Entered. dataTable is " + dataTable);
        productListPageSteps.applyFilters(dataTable);
    }

    @And("User selects {string} product")
    public void userSelectProductAccordingToPrice(String priceInformation) {
        logger.info("Entered. priceInformation is " + priceInformation);
        productListPagePriceProcessSteps.SelectProductAccordingToPrice(priceInformation);
    }

}
