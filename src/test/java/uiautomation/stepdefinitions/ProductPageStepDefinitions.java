package uiautomation.stepdefinitions;

import io.cucumber.java.en.When;
import uiautomation.steps.ProductPageSteps;
import uiautomation.utils.LoggerManager;

public class ProductPageStepDefinitions {
    ProductPageSteps productPageSteps=new ProductPageSteps();
    LoggerManager logger = new LoggerManager();



    @When("User adds the product to the cart")
    public void userAddsTheProductToCart(){
        logger.info("Entered.");
        productPageSteps.addProductToCart();
    }





}
