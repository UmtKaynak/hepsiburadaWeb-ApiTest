package uiautomation.stepdefinitions;

import io.cucumber.java.en.When;
import uiautomation.steps.CartPageSteps;
import uiautomation.utils.LoggerManager;

public class CartPageStepDefinitions {
    LoggerManager logger=new LoggerManager();
    CartPageSteps cartPageSteps=new CartPageSteps();

    @When("User compares the price In cart page")
    public void userCompareCartPriceWithSavedPrice(){
        logger.info("Entered.");
        cartPageSteps.cartPagePriceControl();
    }


    @When("User checks that the cart is empty")
    public void userDeleteTheProductIfNotEmpty(){
        logger.info("Entered.");
        cartPageSteps.deleteBasketIfNotEmpty();
    }
}
