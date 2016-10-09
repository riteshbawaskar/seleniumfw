package clindox.com.glue;
import clindox.com.pages.*;
import clindox.com.utils.ConfigProvider;
import clindox.com.utils.DriverProvider;
import clindox.com.utils.ReportProvider;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import org.junit.Assert;
import org.omg.CORBA.portable.Streamable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UpdateAnswersSteps {

    DashboardPage dashboardPage;
    InputDataPage inputDataPage;
    SubjectListPage subjectListPage;
    VisitPage visitPage;
    WebDriver driver;

    @Given("^user navigates to \"([^\"]*)\"$")
    public void user_navigates_to(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver = DriverProvider.getBrowser();
        dashboardPage = PageFactory.initElements(driver, DashboardPage.class);

        if(arg1.equals("Monitor Input Data"))
            dashboardPage.NavigateToMonitorInputData();
        //throw new PendingException();
    }

    @Given("^selects study as \"([^\"]*)\"$")
    public void selects_study_as(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver = DriverProvider.getBrowser();
        inputDataPage = PageFactory.initElements(driver, InputDataPage.class);
        inputDataPage.gotoSubjects(arg1);
        ReportProvider.getTest().log(LogStatus.INFO," Select Study : " + arg1);
       // ReportProvider.getTest().addBase64ScreenShot()
       // throw new PendingException();
    }

    @When("^user enters data for subject \"([^\"]*)\" and visit \"([^\"]*)\"$")
    public void user_enters_data_for_subject_and_visit(String Subject, String visit, DataTable questions) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
       // throw new PendingException();
        driver = DriverProvider.getBrowser();


        subjectListPage = PageFactory.initElements(driver, SubjectListPage.class);
        ReportProvider.getTest().log(LogStatus.INFO," Select Subject : " + Subject + "Visit :"+ visit);
        subjectListPage.Selectvisit(Subject,visit);

        visitPage =  PageFactory.initElements(driver, VisitPage.class);


       List<DataTableRow> rows = questions.getGherkinRows();

        for(DataTableRow question : rows){
           List<String> cells = question.getCells();
            visitPage.SetWebDriver(driver);
            visitPage.AnswerTheQuestion(cells.get(0),cells.get(1),cells.get(2));
            ReportProvider.getTest().log(LogStatus.INFO,cells.get(0) + " = " + cells.get(1));
            ReportProvider.GenerateSnapshotReport(driver, visitPage.currentQuestion);
       }


    }

}


