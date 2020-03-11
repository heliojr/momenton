package org.interview.momenton.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductView extends Common{

    private static final By ADD_TO_BAG_ICON = new By.ByCssSelector("[data-automation=add-to-bag]");

    public ProductView(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void addProductToBag() {
        wait.until(ExpectedConditions.elementToBeClickable(ADD_TO_BAG_ICON)).click();
    }
}
