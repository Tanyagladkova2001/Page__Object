package web.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;


public class CatalogPage extends BasePage {

    public static final String BASE_URL = "https://www.saucedemo.com/inventory.html";

    private static final By TITLE_LOCATOR = By.xpath("//span[@class='title' and text()='Products']");


    private static final String PRODUCT_XPATH_PATTERN =
            "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//button";

    private static final By THREE_LINES_THING = By.id("react-burger-menu-btn");
    private static final By LOGOUT = By.id("logout_sidebar_link");

    private static final By BACKPACK_LOCATOR = By.xpath("//div[contains(text(),'Sauce Labs Backpack')]");

    private static final By CART_BADGE = By.xpath("//span[@class='shopping_cart_badge']");
    private static final By PRODUCT_SORT = By.xpath("//select[.//option]");
    public static final By PRODUCT_SORT_A_Z = By.xpath("//select[.//option]/option[contains(.,'Name (A to Z)')]");




    public CatalogPage(WebDriver driver) {
        super(driver);
        this.baseUrl = BASE_URL;
        this.basePageElementId = TITLE_LOCATOR;
    }

    public void addProductToCart(String partialProductTitle) {
        driver.findElement(By.xpath(String.format(PRODUCT_XPATH_PATTERN, partialProductTitle))).click();
    }
    public boolean openMenu(){
        driver.findElement(THREE_LINES_THING).click();
        Wait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(ElementNotInteractableException.class);
        WebElement crossButton = fluent.until(driver -> {
            System.out.println(" FLUENT WAIT ");
            driver.findElement(THREE_LINES_THING).sendKeys("");
           return driver.findElement(THREE_LINES_THING);
    });
            return crossButton.isDisplayed();
    }

    public void Logout(){
        openMenu();
        driver.findElement(LOGOUT).click();
    }

    public void switchToProductPage(){
        driver.findElement(BACKPACK_LOCATOR).click();

    }

    public void isBadgeChanges(){
        driver.findElement(CART_BADGE).getText();

    }

    public void productSortContainer(){
        driver.findElement(PRODUCT_SORT).click();
        driver.findElement(PRODUCT_SORT_A_Z).click();

        }
    }
