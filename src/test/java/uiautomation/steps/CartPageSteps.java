package uiautomation.steps;

import static uiautomation.pages.CartPage.*;
import static uiautomation.pages.HomePage.PRODUCT_COUNT_IN_THE_CART;

public class CartPageSteps extends BaseSteps {

    public void cartPagePriceControl() {
        logger.info("Entered.");
        comparePrices(CART_PRICE);
    }

    public void deleteBasketIfNotEmpty() {
        logger.info("Entered.");
        if (!getText(PRODUCT_COUNT_IN_THE_CART).equals("0")) {
            logger.info("Basket is not empty so firstly basket is get empty");
            deleteBasket();
        }
    }

    public void deleteBasket() {
        logger.info("Entered.");
        clickElement(PRODUCT_COUNT_IN_THE_CART);
        clickElement(DELETE_PRODUCT_ON_CART_BUTTON);
        clickElement(DELETE_ALL_PRODUCTS_BUTTON);
        clickElement(HEPSI_BURADA_HEADER);
    }
}
