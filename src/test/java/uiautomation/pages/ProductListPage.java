package uiautomation.pages;

import org.openqa.selenium.By;

public class ProductListPage {

    public static By FILTER_SECTION = By.id("stickyVerticalFilter");
    public static By BRAND_FILTERS_OPTIONS = By.xpath("//input[@name='markalar']");
    public static By SCREEN_SIZE_FILTERS_OPTIONS = By.xpath("//input[@name='ekranboyutu']/following-sibling::div/a");
    public static By RAM_CAPACITY_FILTERS_OPTIONS = By.xpath("//input[@name='ramkapasitesi']/following-sibling::div/a");


    public static By PRODUCT_PRICE_TEXT = By.xpath("//ul[contains(@class,'productListContent')]//div[@data-test-id='price-current-price']");
}
