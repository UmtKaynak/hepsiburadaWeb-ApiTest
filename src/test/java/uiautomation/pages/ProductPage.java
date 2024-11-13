package uiautomation.pages;

import org.openqa.selenium.By;

public class ProductPage {


    public static final By PRODUCT_PRICE_TEXT = By.xpath("//div[@data-test-id='price-current-price']");
    public static final By ADD_TO_CART_BUTTON = By.xpath("//button[@data-test-id='addToCart']");
    public static final By CONTINUE_THE_CART_PAGE_BUTTON = By.xpath("//div[contains(@class,'ProductOnBasketHeade')]/button[not(@kind)]");

}
