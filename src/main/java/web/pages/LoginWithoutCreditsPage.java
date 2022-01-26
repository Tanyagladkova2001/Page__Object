package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static web.pages.LoginPage.BASE_URL;

public class LoginWithoutCreditsPage extends BasePage {
    private static final By USERNAME_TEXT_FIELD = By.id("user-name");
    private static final By PASSWORD_TEXT_FIELD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By ERROR = By.xpath("//div[@class='error-message-container error']");



    public LoginWithoutCreditsPage(WebDriver driver) {
            super(driver);
            this.baseUrl = BASE_URL;
        }

        public void login(String username, String password) {
            driver.findElement(USERNAME_TEXT_FIELD).sendKeys(username);
            driver.findElement(PASSWORD_TEXT_FIELD).sendKeys(password);
            driver.findElement(LOGIN_BUTTON).click();
        }
        public void errorEnter(){
            List<WebElement> credentials = driver.findElements(USERNAME_TEXT_FIELD);
            if (credentials.isEmpty()) {
                driver.findElement(ERROR).getText();}
        }


    }


