package uiautomation.steps;


public class HomePageSteps extends BaseSteps {

    public void selectCategoryAndSubCategory(String menuItem, String categoryName, String subCategoryName) {
        logger.info("Selected menuItem : "+menuItem+" categoryName "+ categoryName+" subCategory "+ subCategoryName);
        hoverElement(createXPathByText("//span", menuItem, "/parent::span"));
        hoverElement(createXPathByText("//div[contains(@class,'navigationContainer')]//a", categoryName, ""));
        clickElement(createXPathByText("//div[contains(@class,'navigationContainer')]//a", subCategoryName, ""));
    }
}
