package uiautomation.steps.productlistpage;

import org.openqa.selenium.WebElement;
import uiautomation.steps.BaseSteps;

import java.util.List;
import java.util.Random;

import static uiautomation.pages.ProductListPage.PRODUCT_PRICE_TEXT;

public class ProductListPagePriceProcessSteps extends BaseSteps {

    public enum PriceType {
        CHEAP,
        RANDOM,
        EXPENSIVE;
    }

    public void SelectProductAccordingToPrice(String priceInformation) {
        logger.info("Entered.");
        List<WebElement> products = findElements(PRODUCT_PRICE_TEXT);
        PriceType priceType = PriceType.valueOf(priceInformation.toUpperCase());
        switch (priceType) {
            case CHEAP:
                clickElement(findElementAccordingToPrice(products, true));
                logger.info("Cheapest product is selected");
                break;
            case RANDOM:
                Random random = new Random();
                int elementIndex = random.nextInt(products.size());
                double productPrice = convertStringToDouble(getText(products.get(elementIndex)));
                saveProductPrice(productPrice);
                clickElement(products.get(elementIndex));
                logger.info("Random product is selected");
                break;
            case EXPENSIVE:
                clickElement(findElementAccordingToPrice(products, false));
                logger.info("The most expensive product is selected");
                break;
        }
    }


    private WebElement findElementAccordingToPrice(List<WebElement> productPriceList, boolean isCheapest) {
        logger.info("Entered.");
        WebElement selectedElement = productPriceList.get(0);
        double selectedPrice = convertStringToDouble(getText(selectedElement));
        for (WebElement webElement : productPriceList) {
            double currentPrice = convertStringToDouble(getText(webElement));
            if ((isCheapest && currentPrice < selectedPrice) || (!isCheapest && currentPrice > selectedPrice)) {
                selectedPrice = currentPrice;
                selectedElement = webElement;
            }
        }
        logger.info("The most Expensive element is " + selectedPrice);
        saveProductPrice(selectedPrice);
        return selectedElement;
    }


    private void saveProductPrice(double expectedPrice) {
        logger.info("Entered Saved price is " + expectedPrice);
        savedValues.put("ProductListPagePrice", expectedPrice);
    }
}
