package clindox.com.pages;

import clindox.com.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BasePage{

    @FindBy(xpath = "//div[@class='pull-right member-box']")
    WebElement UserOptions;
    @FindBy(xpath="//a[contains(text(), 'Switch Profile')]")
    WebElement SwithProfile;
    @FindBy(className = "ddlrole")
    WebElement SelectRole;
    @FindBy(xpath="//a[@id='ctl00_RoleSection2_saveQuestion']")
    WebElement SelectRole_Gobtn;

    @FindBy(xpath="//span[@id='ctl00_lblUserRole']")
    WebElement CurrentUserRole;

    public void SwitchProfile(String Profile )
    {

            UserOptions.click();
            SwithProfile.click();
            WaitforElement(By.className("ddlrole"));
            SelectRole.sendKeys(Profile);
            SelectRole_Gobtn.click();

    }

    public boolean IsCurrentRole(String arg1) {
        return CurrentUserRole.getText().equals(arg1);
    }
}
