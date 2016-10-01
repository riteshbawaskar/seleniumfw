package clindox.com.glue;

import clindox.com.pages.DashboardPage;
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

public class SelectRoleSteps {
    ConfigProvider configProvider = new ConfigProvider();
    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Given("^login to application with default user$")
    public void login_to_application_with_default_user() throws Throwable {
        driver = DriverProvider.getBrowser();
        driver.get(configProvider.getConfiguration("url"));
        loginPage = PageFactory.initElements(driver, LoginPage.class);


        String arg1 = configProvider.getConfiguration("username");
        String arg2 = configProvider.getConfiguration("password");

        loginPage.EnterLoginDetails(arg1,arg2);
        loginPage.ClickLoginButton();
        // Write code here that turns the phrase above into concrete actions
       // throw new PendingException();
    }

    @Given("^user is on Dashboard Page$")
    public void user_is_on_Dashboard_Page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
    }

    @When("^changes role as \"([^\"]*)\"$")
    public void changes_role_as(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        dashboardPage.SwitchProfile();
        //throw new PendingException();
    }

    @Then("^role should be changed successfully as \"([^\"]*)\"$")
    public void role_should_be_changed_successfully_as(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       // throw new PendingException();
    }

}
