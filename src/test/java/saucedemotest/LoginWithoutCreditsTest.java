package saucedemotest;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginWithoutCreditsTest extends BaseTest {
    WebDriver driver;

    @Test
    public void LOGIN_WITHOUT_CREDITS(){
        loginPage.open();
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");
        loginWithoutCreditsPage.login("","");
        loginWithoutCreditsPage.errorEnter();

    }
}
