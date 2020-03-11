package org.interview.momenton;

import org.interview.momenton.pages.Cart;
import org.interview.momenton.pages.Common;
import org.interview.momenton.pages.ProductView;
import org.interview.momenton.pages.ProductListing;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyersTests {

    static WebDriver driver;
    static WebDriverWait wait;

    @Before
    public void startBrowser() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }

    //    @Test
    public void testSearchForTv() {
        driver.get("https://www.myer.com.au");
        Common commonPage = new Common(driver, wait);
        commonPage.searchForProduct("4k smart tv");

        ProductListing productsListPage = new ProductListing(driver, wait);
        Assert.assertTrue(productsListPage.isProductHeaderCorrect("Search results for ‘4k smart tv’"));

        // Checking the number of TVs returned in the search . The value is hardcoded, but it should be based in a previous
        // API call or database query to check the expected value ( or we should mock the data )
        Assert.assertEquals(7, (long) productsListPage.getNumberOfVisibleProducts());
    }

    @Test
    public void testAddProductToCart() {
        driver.get("https://www.myer.com.au/p/hisense-r6-series-50inch-127cm-ultra-hd-led-hdr-smart-tv");

        ProductView prodViewPage = new ProductView(driver, wait);
        prodViewPage.addProductToBag();

        // a slide panel may be opened
        prodViewPage.closeSlidePanel();

        Assert.assertTrue(prodViewPage.isCartCounterCorrect(1));
        prodViewPage.openCart();

        Cart cartPage = new Cart(driver, wait);
        Assert.assertTrue(cartPage.isPageVisible());
        Assert.assertEquals(1, cartPage.getNumberItems());

        // we have to verify not only the number of items in the cart, but also if they are correct.
        // Other assertions to verify product name, qty , price and delivery costs must be added in this test case to
        // ensure the add card button is working correctly.
    }
}
