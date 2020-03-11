package org.interview.momenton.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart extends BasePage{

    private static final By CART_PAGE_TITLE = new By.ByCssSelector("#my-bag-header > div > div:nth-child(1) > h1");
    private static final By PRODUCT_TITLE_ID = new By.ByCssSelector("[data-automation=product-title]");
    private static final By NUMBER_ITEMS_BAG = new By.ByCssSelector("[data-automation=item-count-header]");

    public Cart(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public Boolean isPageVisible() {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(CART_PAGE_TITLE, "Your Bag"));
    }

    public long getNumberItems() {
        return Long.parseLong(wait.until(ExpectedConditions.visibilityOfElementLocated(NUMBER_ITEMS_BAG)).getText().split("")[0]);

    }
}
