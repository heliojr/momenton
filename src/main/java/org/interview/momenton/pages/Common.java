package org.interview.momenton.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common extends BasePage{

    private static final By CART_ICON = new By.ByCssSelector("[data-automation=header-bag]");
    private static final By COUNTER_CART = new By.ByCssSelector("[data-automation=mini-bag-count]");
    private static final By SEARCH_BUTTON = new By.ByCssSelector("[data-automation=header-search]");
    private static final By INPUT_SEARCH_BUTTON = new By.ByCssSelector("[data-automation=input-search]");

    private static final By CLOSE_SLIDE_PANEL_BUTTON = new By.ByCssSelector("[data-automation=slide-panel-close-button]");

    public Common(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void searchForProduct ( String productName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_BUTTON)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(INPUT_SEARCH_BUTTON)).sendKeys(productName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(INPUT_SEARCH_BUTTON)).sendKeys(Keys.ENTER);
    }

    public Boolean isCartCounterCorrect(Integer number) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(COUNTER_CART, String.valueOf(number)));
    }

    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(CART_ICON)).click();
    }

    public void closeSlidePanel() {
        wait.until(ExpectedConditions.elementToBeClickable(CLOSE_SLIDE_PANEL_BUTTON)).click();
    }
}
