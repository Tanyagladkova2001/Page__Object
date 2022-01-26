
package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    private static final By USERNAME_TEXT_FIELD = By.id("first-name");
    private static final By PASSWORD_TEXT_FIELD = By.id("last-name");
    private static final By ZIP_POSTAL_CODE = By.id("postal-code");
    private static final By CONTINUE_BUTTON = By.xpath("//input[@class='submit-button btn btn_primary cart_button btn_action']");
    private static final By CHECKOUT_PLACEHOLDER_USERNAME= By.xpath("//div/input[@placeholder='First Name']");
    private static final By CHECKOUT_PLACEHOLDER_LASTNAME = By.xpath("//div/input[@placeholder='Last Name']");
    private static final By ZIP = By.xpath("//div/input[@placeholder='Zip/Postal Code']");


    public void CredentialsInput(String firstName, String lastname, String ZIP) {
        driver.findElement(USERNAME_TEXT_FIELD).sendKeys(firstName);
        driver.findElement(PASSWORD_TEXT_FIELD).sendKeys(lastname);
        driver.findElement(ZIP_POSTAL_CODE).sendKeys(ZIP);
        driver.findElement(CONTINUE_BUTTON).click();
    }
    public void checkoutPlaceholder(){
        driver.findElement(CHECKOUT_PLACEHOLDER_USERNAME).getAttribute("First Name");
        driver.findElement(CHECKOUT_PLACEHOLDER_LASTNAME).getAttribute("Last Name");
        driver.findElement(ZIP).getAttribute("Zip/Postal Code");

    }
}
