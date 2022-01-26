package saucedemotest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CartTest extends BaseTest{
       @BeforeMethod
    private void login() {
        loginPage.open();
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");
        loginPage.login(USERNAME, PASSWORD);
        Assert.assertTrue(catalogPage.isPageLoaded(), "Catalog page is not loaded");
    }

    @Test
    public void removeProductFromCartTest() {
        catalogPage.addProductToCart(TEST_PRODUCT_TITLE);
        cartPage.open();
        Assert.assertTrue(cartPage.isPageLoaded(), "CartPage is not loaded");
        cartPage.removeProductFromCart();

    }
    @Test
    public void CheckoutButton(){
        cartPage.open();
        Assert.assertTrue(cartPage.isPageLoaded(), "Checkout page is not loaded");
        cartPage.CheckoutInCartPage();


    }



}
