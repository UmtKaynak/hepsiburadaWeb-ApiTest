package uiautomation.steps;


import org.junit.jupiter.api.Assertions;

import static uiautomation.pages.ProductPage.*;

public class ProductPageSteps extends BaseSteps{

    public void addProductToCart(){
        logger.info("Entered.");
        comparePrices(PRODUCT_PRICE_TEXT);
        clickElement(ADD_TO_CART_BUTTON);
        Assertions.assertTrue(findElement(CONTINUE_THE_CART_PAGE_BUTTON).isDisplayed(),"Product is not added the Cart");
        clickElement(CONTINUE_THE_CART_PAGE_BUTTON);
    }

}
