package clindox.com.pages;

import clindox.com.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.Console;
import java.util.List;

public class DashboardPage extends BasePage{

    @FindBy(xpath = "//div[@class='navbar-fixed']//li[@class='userDetails valign-wrapper']/a")
    WebElement UserOptions;

    @FindBy(xpath="//div[@class='navbar-fixed']//div[@class='nav-wrapper container']//li[@class='userDetails valign-wrapper']//li[@id='ctl00_Li2']//input[@class='select-dropdown']")
    WebElement SwitchProfile;

    @FindBy(xpath="//div[@class='navbar-fixed']//ul[contains(@id,'select-options-')]")
      WebElement Profilelist;

    @FindBy(xpath="//span[@id='ctl00_lblUserRole']")
    public WebElement CurrentUserRole;

    @FindBy(xpath = "//div[@class='container overflow-container flex-container']//a[@class='button-collapse dropdown-button']/img[contains(@src,'Hamburger_Icon')]")
    public WebElement menuoptions;

    @FindBy(xpath = "//div[@class='container overflow-container flex-container']/div[@class='main-container']//div[@class='col m3']//li[4]/a[@id='ctl00_lnkInputData']/span[@id='ctl00_btnInputData']")
    public WebElement MonitorInputData;
    public void SwitchProfile(String Profile )
    {
        try

        {
            UserOptions.click();
            SwitchProfile.click();
            List<WebElement> elements = Profilelist.findElements(By.xpath(".//li/span"));
            Thread.sleep(1000);
            if (Profile.equals("Admin"))
                elements.get(0).click();
            else if (Profile.equals("Investigator"))
                elements.get(2).click();
            else if (Profile.equals("Monitor"))
                elements.get(3).click();
            else if (Profile.equals("Sponsor"))
                elements.get(4).click();
            else if (Profile.equals("Data Manager"))
                elements.get(1).click();

        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void gotoHomePage() throws Exception
    {
       // WebElement element = driver.findElement(By.xpath("//i[@class='icon-home']"));
       // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
       // Thread.sleep(500);
       /// dashboard_home.click();

    }
    public boolean IsCurrentRole(String arg1) {

        return CurrentUserRole.getText().equals(arg1);
    }

    public void NavigateToMonitorInputData()
    {
        menuoptions.click();
        MonitorInputData.click();

    }

}
