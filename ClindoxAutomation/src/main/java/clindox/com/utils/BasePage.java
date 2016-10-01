package clindox.com.utils;

import org.openqa.selenium.WebDriver;

/**
 * Created by RUPALI on 01/10/2016.
 */
public class BasePage {

    public static WebDriver driver;
    public static ConfigProvider config;

    BasePage()
    {
        driver = DriverProvider.getBrowser();
        config = new ConfigProvider();
    }
}
