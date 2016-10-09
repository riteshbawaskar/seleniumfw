package clindox.com.utils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;


public class BasePage {

    public static WebDriver driver;
    public static ConfigProvider config;

    public BasePage()
    {
        driver = DriverProvider.getBrowser();
        config = new ConfigProvider();
    }



    public void WaitforElement(By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public boolean isElementExist(WebElement we) {
        try {
            we.isDisplayed();
            return true;
        } catch(NoSuchElementException e) {
            return false;
        }
    }
}
