package uiautomation.steps.productlistpage;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import uiautomation.steps.BaseSteps;

import java.util.List;
import java.util.Map;

import static uiautomation.pages.ProductListPage.*;

public class ProductListPageFilterSteps extends BaseSteps {
    /**
     * Bu kısımda datatable formatından yararlanılmıştır. applyFilters istenildiği takdirde filtre eklenerek genişletilebilir bir yapı sunar.
     */

    public void applyFilters(DataTable dataTable) {
        logger.info("Entered.");
        findElement(FILTER_SECTION);
        for (Map<String, String> data : dataTable.asMaps(String.class, String.class)) {
            if (data.containsKey("Brand") && !(data.get("Brand").equalsIgnoreCase("None")))
                filterByUsingElementValue(BRAND_FILTERS_OPTIONS, data.get("Brand"));
            if (data.containsKey("Screen_Size") && !(data.get("Screen_Size").equalsIgnoreCase("None")))
                filterByUsingElementTextValue(SCREEN_SIZE_FILTERS_OPTIONS, data.get("Screen_Size"));
            if (data.containsKey("Ram_Capacity") && !(data.get("Ram_Capacity").equalsIgnoreCase("None")))
                filterByUsingElementTextValue(RAM_CAPACITY_FILTERS_OPTIONS, data.get("Screen_Size"));
        }
    }

    private void filterByUsingElementValue(By filterPath, String filterValue) {
        logger.info("Entered.");
        List<WebElement> elements = findElements(filterPath);
        for (WebElement element : elements) {
            scrollElement(element);
            String elementAttributeValue = getElementAttributeValue(element, "value");
            if (elementAttributeValue.equalsIgnoreCase(filterValue)) {
                clickElement(element);
                refreshPage();
                logger.info("Applied filter is " + filterValue);
                break;
            }
        }
    }

    private void filterByUsingElementTextValue(By filterPath, String filterValue) {
        logger.info("Entered.");
        List<WebElement> elements = findElements(filterPath);
        for (WebElement element : elements) {
            String elementTextValue = getText(element).replaceAll("[^0-9,]+", "");
            if (elementTextValue.equalsIgnoreCase(filterValue)) {
                clickByJs(element);
                refreshPage();
                logger.info("Applied filter is " + filterValue);
                break;
            }
        }
    }

}
