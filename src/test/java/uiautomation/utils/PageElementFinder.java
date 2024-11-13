package uiautomation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.lang.reflect.Field;

public class PageElementFinder {

    private static final String[] PAGE_CLASSES = {
            "HomePage",
            "ProductListPageFilterSteps",
            "ProductPage",
            "CartPage"
    };

    public static By getElement(String pageClassName, String pageElementName) throws NoSuchElementException {
        for (String page : PAGE_CLASSES) {
            if (page.equals(pageClassName)) {
                Class<?> pageClass = null;
                try {
                    pageClass = Class.forName("uiautomation.pages." + pageClassName);
                } catch (ClassNotFoundException e) {
                    throw new NoSuchElementException("Sayfa bulunamadı: " + pageClassName);
                }

                Field[] fields = pageClass.getDeclaredFields();

                for (Field field : fields) {
                    if (By.class.isAssignableFrom(field.getType()) && field.getName().equals(pageElementName)) {
                        field.setAccessible(true);
                        try {
                            return (By) field.get(null);
                        } catch (IllegalAccessException e) {
                            throw new NoSuchElementException("Element erişilemez: " + pageElementName);
                        }
                    }
                }

                throw new NoSuchElementException("Element bulunamadı: " + pageElementName + " in " + pageClassName);
            }
        }

        throw new NoSuchElementException("Sayfa bulunamadı: " + pageClassName);
    }
}

