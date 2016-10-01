package clindox.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by RUPALI on 01/10/2016.
 */
public class LoginPage {

    @FindBy(id="username")
    public WebElement username;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(id="btnsign")
    public WebElement signin;

    @FindBy(id="ErrorMsg")
    public WebElement validationresult;

    @FindBy(xpath="//h1[contains(text(), 'Dashboard')]")
    public WebElement Dashboard;

    public WebDriver driver;
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
            String data = validationresult.getText();
            if (data.contains(result))
                return true;
            else
                return false;
        }
    }
}
