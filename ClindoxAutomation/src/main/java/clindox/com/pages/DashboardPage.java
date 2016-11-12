package clindox.com.pages;

import clindox.com.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DashboardPage extends BasePage{

    @FindBy(xpath = "//div[@class='pull-right member-box']")
    WebElement UserOptions;
    @FindBy(xpath="//a[contains(text(), 'Switch Profile')]")
    WebElement SwithProfile;
    @FindBy(className = "ddlrole")
    WebElement SelectRole;
    @FindBy(xpath="//a[@id='ctl00_RoleSection2_saveQuestion']")
    WebElement SelectRole_Gobtn;

    @FindBy(xpath="//a[@id='ctl00_hrefdash']")
    public WebElement dashboard_home;

    @FindBy(xpath="//span[@id='ctl00_lblUserRole']")
    public WebElement CurrentUserRole;

    @FindBy(xpath="//div[@class='shortcuts']//span[text()='Create Study']")
    WebElement CreateStudy;

    @FindBy(xpath="//div[@class='shortcuts']//span[text()='Study Design']")
    WebElement Study_Design;

    @FindBy(xpath="//div[@class='shortcuts']//span[contains(text(),'Add or manage Study')]")
    WebElement Add_or_Manage_Study_Logs;

    @FindBy(xpath="//a[@id='ctl00_ContentPlaceHolder1_lnkInputData']")
    WebElement MonitorInputData;

    @FindBy(xpath="//div[@class='shortcuts']//i[@class='shortcut-icon icon-user-md']")
    WebElement Add_or_manage_users;

    @FindBy(xpath="//div[@class='shortcuts']//span[text()='View the Query list']")
    WebElement view_the_query_list;

    public void SwitchProfile(String Profile )
    {
            UserOptions.click();
            SwithProfile.click();
            WaitforElement(By.className("ddlrole"));
            SelectRole.sendKeys(Profile);
            SelectRole_Gobtn.click();

    }

    public void gotoHomePage() throws Exception
    {
        WebElement element = driver.findElement(By.xpath("//i[@class='icon-home']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
        dashboard_home.click();

    }
    public boolean IsCurrentRole(String arg1) {
        return CurrentUserRole.getText().equals(arg1);
    }

    public void NavigateToMonitorInputData()
    {
        MonitorInputData.click();

    }

    public void navigateToBreadcrumbs(String strlink)
    {
        List<WebElement> links = driver.findElements(By.xpath("//div[@class='container']/ul[@class='breadcrumb']/li"));
        for(WebElement link :links)
        {
            if(link.getText().trim().equals(strlink)) {
                link.click();
                try {
                    driver.switchTo().alert().accept();
                }
                catch (Exception ex) { }
                return;
            }
        }
    }
}
