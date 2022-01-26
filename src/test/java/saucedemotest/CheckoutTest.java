package saucedemotest;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CheckoutTest extends BaseTest {

    @BeforeMethod
    private void login() {
        loginPage.open();
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");
        loginPage.login(USERNAME, PASSWORD);
        Assert.assertTrue(catalogPage.isPageLoaded(), "Catalog page is not loaded");
    }

    @Test
    public void PurchaseCheckoutTest(){
        cartPage.open();
        Assert.assertTrue(cartPage.isPageLoaded(), "CartPage page is not loaded");
        cartPage.CheckoutInCartPage();
        checkoutPage.CredentialsInput("Tanya","Gladkova","12345");
        checkoutOverview.FinishProcess();
    }
    @Test
    public void PlaceholdersTest(){
        cartPage.open();
        cartPage.CheckoutInCartPage();
        checkoutPage.checkoutPlaceholder();
    }
}
