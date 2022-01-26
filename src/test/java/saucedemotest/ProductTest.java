package saucedemotest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest{

    @BeforeMethod
    private void login() {
        loginPage.open();
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");
        loginPage.login(USERNAME, PASSWORD);
        Assert.assertTrue(catalogPage.isPageLoaded(), "Catalog page is not loaded");
    }

    @Test
    public void addToCartOnProductPageTest(){
        catalogPage.switchToProductPage();
        Assert.assertTrue(productPage.isPageLoaded(), "Product page is not loaded");
        productPage.addToCartOnProductPage();
        Assert.assertTrue(cartPage.isPageLoaded(), "Product page is not loaded");


    }
}
