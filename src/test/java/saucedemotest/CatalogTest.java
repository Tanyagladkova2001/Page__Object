package saucedemotest;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CatalogTest extends BaseTest {

     @BeforeMethod
     private void login() {
         loginPage.open();
         Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");
         loginPage.login(USERNAME, PASSWORD);
         Assert.assertTrue(catalogPage.isPageLoaded(), "Catalog page is not loaded");
     }

    @Test
    public void addProductToCartTest() {
        catalogPage.addProductToCart(TEST_PRODUCT_TITLE);
        cartPage.open();
        cartPage.isPageLoaded();

    }
    @Test
    public void openMenuTest(){
         Assert.assertTrue(catalogPage.isPageLoaded(), "Catalog page is not loaded");
         catalogPage.openMenu();
    }
    @Test
    public void LogoutTest(){
        Assert.assertTrue(catalogPage.isPageLoaded(), "Catalog page is not loaded");
         catalogPage.Logout();
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");
    }
    @Test
    public void switchToProductPageTest(){
         catalogPage.switchToProductPage();
         Assert.assertTrue(productPage.isPageLoaded(), "Product page is not loaded");

    }

    @Test
    public void isBadgeChangesTest(){
         catalogPage.addProductToCart(TEST_PRODUCT_TITLE);
         catalogPage.isBadgeChanges();
    }
    @Test
    public void productSortContainerTest() {
        catalogPage.productSortContainer();
    }

}
