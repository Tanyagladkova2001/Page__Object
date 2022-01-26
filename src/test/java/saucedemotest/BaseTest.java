package saucedemotest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import web.pages.*;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected CatalogPage catalogPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    protected CheckoutOverview checkoutOverview;
    protected ProductPage productPage;
    protected LoginWithoutCreditsPage loginWithoutCreditsPage;


    public static final String USERNAME = "standard_user";
    public static final String PASSWORD = "secret_sauce";

    public static final String TEST_PRODUCT_TITLE = "Test.allTheThings() T-Shirt (Red)";

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--ignore-popup-blocking");
        chromeOptions.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        loginPage = new LoginPage(driver);
        catalogPage = new CatalogPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverview = new CheckoutOverview(driver);
        productPage = new ProductPage(driver);
        loginWithoutCreditsPage = new LoginWithoutCreditsPage(driver);

    }

    @AfterClass(alwaysRun=true)
    public void teardown() {
        driver.close();
        driver.quit();
    }

}