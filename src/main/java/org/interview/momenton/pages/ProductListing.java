package org.interview.momenton.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductListing extends Common{

    private static final By TITLE_ID = new By.ByCssSelector("[data-automation=product-listing-title]");
    private static final By PRODUCT_NAME_ID = new By.ByCssSelector("[data-automation=product-name]");

    public ProductListing(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public Boolean isProductHeaderCorrect(String title) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(TITLE_ID, title));
    }

    public Integer getNumberOfVisibleProducts() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(PRODUCT_NAME_ID)).size();
    }
}
