package web.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverview extends BasePage{
    public CheckoutOverview(WebDriver driver) {
        super(driver);
    }
    private static final By FINISH_LOCATOR = By.id("finish");
    private static final By BACK_HOME = By.cssSelector("button[name='back-to-products']");
    private static final By BACK_HOME_PAGE = By.id("checkout_complete_container");


    public void FinishProcess(){
        driver.findElement(FINISH_LOCATOR).click();
        driver.findElement(BACK_HOME_PAGE);
        driver.findElement(BACK_HOME).click();

    }
}
