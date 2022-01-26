package saucedemotest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.pages.LoginPage;

public class LoginTest extends BaseTest {


    public void openLoginPage() {
        loginPage.open();
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");
    }

    @BeforeMethod
    public void validCredentialsLoginTest() {
        openLoginPage();
        loginPage.login(USERNAME, PASSWORD);
        Assert.assertTrue(catalogPage.isPageLoaded(), "Catalog page is not loaded");
    }

    @Test
    public void USERNAME_AND_PASSWORD_PLACEHOLDERS_TEST() {
        openLoginPage();
        Assert.assertEquals(
                loginPage.getUsernamePlaceholder(),
                LoginPage.USERNAME_TEXT_FIELD_PLACEHOLDER,
                "Username placeholder is not valid"
        );
        Assert.assertEquals(
        loginPage.getPasswordPlaceholder(),
                LoginPage.PASSWORD_TEXT_FIELD_PLACEHOLDER,
                "Password placeholder is not valid"
        );
    }



}