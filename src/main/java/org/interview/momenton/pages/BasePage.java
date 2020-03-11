package org.interview.momenton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver ;
    WebDriverWait wait ;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver ;
        this.wait = wait ;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
