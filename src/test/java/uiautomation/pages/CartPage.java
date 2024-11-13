package uiautomation.pages;

import org.openqa.selenium.By;

public class CartPage {

public static final By CART_PRICE=By.cssSelector("#basket_payedPrice span");
public static final By DELETE_PRODUCT_ON_CART_BUTTON=By.xpath("//div[contains(@class,'basket_delete')]");
public static final By DELETE_ALL_PRODUCTS_BUTTON=By.xpath("//button[text()='Tümünü sil']");
public static final By HEPSI_BURADA_HEADER=By.xpath("//a[@title='Hepsiburada']");

}
