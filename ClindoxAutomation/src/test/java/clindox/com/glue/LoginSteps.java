package clindox.com.glue;

import clindox.com.pages.LoginPage;
import clindox.com.utils.ConfigProvider;
import clindox.com.utils.DriverProvider;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by RUPALI on 01/10/2016.
 */
public class LoginSteps {
    ConfigProvider configProvider = new ConfigProvider();
    WebDriver driver;
    LoginPage loginPage;


    @Given("^user launch the application$")
    public void user_launch_the_application() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver = DriverProvider.getBrowser();
        driver.get(configProvider.getConfiguration("url"));

    }

    @Given("^enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enter_and(String arg1, String arg2) throws Throwable {

        //System.out.print(arg1);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        if(arg1.equals("default"))
            arg1 = configProvider.getConfiguration("username");
        if(arg2.equals("default")) arg2 = configProvider.getConfiguration("password");

        loginPage.EnterLoginDetails(arg1, arg2 );
    }

    @When("^clicked on Login button$")
    public void clicked_on_Login_button() throws Throwable {
        loginPage.ClickLoginButton();
        // Write code here that turns the phrase above into concrete actions
       // throw new PendingException();
    }

    @Then("^user should get result as \"([^\"]*)\"$")
    public void user_should_get_result_as(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
      //  throw new PendingException();
        Assert.assertTrue(loginPage.ValidateLogin(arg1));
    }

}
