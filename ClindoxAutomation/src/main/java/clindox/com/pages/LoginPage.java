package clindox.com.pages;

import clindox.com.utils.BasePage;
import clindox.com.utils.ReportProvider;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;

public class LoginPage extends BasePage {

    @FindBy(id="username")
    public WebElement username;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(id="btnsign")
    public WebElement signin;

    @FindBy(id="ErrorMsg")
    public WebElement validationresult;

    @FindBy(xpath="//div[@id='ValidationSummary1']/ul/li")
    public List<WebElement> validationSummary;

    @FindBy(xpath="//h1[contains(text(), 'Dashboard')]")
    public WebElement Dashboard;

    public WebDriver driver;

    public LoginPage() {
    }



    public void setDriver(WebDriver driver){
        this.driver = driver;
    }

    public void EnterLoginDetails(String inputusername, String inputPassword )
    {
        System.out.println(inputusername);
        username.sendKeys(inputusername);
        password.sendKeys(inputPassword);

    }

    public void ClickLoginButton()
    {
        signin.click();
    }

    public boolean ValidateLogin(String result) {

        if(result.equals("successful"))
            return(Dashboard.isDisplayed());
        else
        {

            if(validationSummary.size() <= 0) {
                String data = validationresult.getText();
                if (data.contains(result))
                    return true;
                else
                    return false;
            }
            else {
                String data = validationSummary.get(0).getText();
                if (data.contains(result))
                    return true;
                else
                    return false;
            }
        }
    }


}
