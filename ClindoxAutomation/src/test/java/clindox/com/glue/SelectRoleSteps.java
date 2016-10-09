package clindox.com.glue;

import clindox.com.pages.DashboardPage;
import clindox.com.pages.LoginPage;
import clindox.com.utils.ConfigProvider;
import clindox.com.utils.DriverProvider;
import clindox.com.utils.ReportProvider;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.omg.CORBA.portable.Streamable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SelectRoleSteps {
    ConfigProvider configProvider = new ConfigProvider();
    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;



    @Given("^login to application with default user$")
    public void login_to_application_with_default_user() throws Throwable {

        String url  = configProvider.getConfiguration("url");
        driver = DriverProvider.getBrowser();
        driver.get(url);

        if(driver.getCurrentUrl().contains("Dashboard.aspx")) return;

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

    @Given("^set user role as \"([^\"]*)\"$")
    public void set_user_role_as(String role) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        dashboardPage.SwitchProfile(role);
        ReportProvider.getTest().log(LogStatus.INFO,"switch profile to " + role);
    }

    @When("^changes role as \"([^\"]*)\"$")
    public void changes_role_as(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        dashboardPage.SwitchProfile(arg1);
        ReportProvider.getTest().log(LogStatus.INFO,"switch profile to " + arg1);
        //throw new PendingException();
    }

    @Then("^role should be changed successfully as \"([^\"]*)\"$")
    public void role_should_be_changed_successfully_as(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       // throw new PendingException();
        Assert.assertTrue(dashboardPage.IsCurrentRole(arg1));
        ReportProvider.GenerateSnapshotReport(driver, dashboardPage.CurrentUserRole);
        ReportProvider.getTest().log(LogStatus.PASS,"switch profile successfully to " + arg1);
    }

}
