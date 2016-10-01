package clindox.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {

    @FindBy(xpath = "//div[@class='pull-right member-box']")
    WebElement UserOptions;
    @FindBy(xpath="//a[contains(text(), 'Switch Profile')]/")
    WebElement SwithProfile;
    @FindBy(className = "ddlrole")
    WebElement SelectRole;
    @FindBy(xpath="//a[contains(text(), 'Go')]/")
    WebElement SelectRole_Gobtn;

    public void SwitchProfile()
    {
        try {
            UserOptions.click();
            wait(1000);
            SwithProfile.click();
        }catch (InterruptedException ex) {}
    }

}
