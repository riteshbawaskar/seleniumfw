package clindox.com.glue;
import clindox.com.pages.*;
import clindox.com.utils.ConfigProvider;
import clindox.com.utils.DriverProvider;
import clindox.com.utils.ExcelReader;
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

import static clindox.com.utils.DriverProvider.configProvider;

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

    @Given("^User Selects Visit \"([^\"]*)\" and Section \"([^\"]*)\"$")
    public void user_Selects_Visit_and_Section(String visit, String section) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        driver = DriverProvider.getBrowser();
        visitPage =  PageFactory.initElements(driver, VisitPage.class);
        visitPage.SetWebDriver(driver);
        visitPage.SelectVisit(visit);
        visitPage.SelectSection(section);
        ReportProvider.getTest().log(LogStatus.INFO," Select Visit : " + visit + "Section :"+ section);

    }

    @Given("^user enters data for subject \"([^\"]*)\" and visit \"([^\"]*)\"$")
    public void user_enters_data_for_subject_and_visit(String Subject, String visit) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        subjectListPage = PageFactory.initElements(driver, SubjectListPage.class);
        ReportProvider.getTest().log(LogStatus.INFO," Select Subject : " + Subject + "Visit :"+ visit);
        subjectListPage.SelectSubject(Subject,visit);
    }

    @When("^User enters data in control$")
    public void user_enters_data_in_control(DataTable questions) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)


        driver = DriverProvider.getBrowser();

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

    @Then("^data should be saved successfully$")
    public void data_should_be_saved_successfully() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @When("^User Enters data from Input Sheet$")
    public void user_Enters_data_from_Input_Sheet() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String inputFile = configProvider.getConfiguration("inputdataSheet");
        ExcelReader reader = new ExcelReader(inputFile);

        driver = DriverProvider.getBrowser();
        visitPage =  PageFactory.initElements(driver, VisitPage.class);
        visitPage.SetWebDriver(driver);
        dashboardPage = PageFactory.initElements(driver, DashboardPage.class);

        dashboardPage.gotoHomePage();
        Thread.sleep(2000);
        dashboardPage.NavigateToMonitorInputData();
        Thread.sleep(2000);

        for(String Sheet : reader.getWorksheets())
        {
            List<String> headers = reader.getData(Sheet,0);
            int startInputRow = 1;


            ReportProvider.getTest().log(LogStatus.INFO, " Select Visit : " +Sheet);

            List<String> inputData = reader.getData(Sheet,startInputRow);


            for(int nRow =startInputRow;nRow<=reader.getRowCount(Sheet);nRow++)
            {
                try {

                    subjectListPage = PageFactory.initElements(driver, SubjectListPage.class);
                    inputDataPage = PageFactory.initElements(driver, InputDataPage.class);
                    dashboardPage = PageFactory.initElements(driver, DashboardPage.class);

                    dashboardPage.navigateToBreadcrumbs("Input Study's List");
                    Thread.sleep(1000);
                    Boolean tableContent = false;
                    String tableRow = "1";
                    ReportProvider.getTest().log(LogStatus.INFO, " Enter data for Row  : " +nRow);

                    String CRFID = inputData.get(0);
                    inputDataPage.gotoSubjects(CRFID);
                    ReportProvider.getTest().log(LogStatus.INFO," Select Study : " + CRFID);

                    List<String> Data = reader.getData(Sheet, nRow);

                    String Subject = Data.get(2);
                    String Visit = headers.get(5);
                    Subject = Subject.replace(".0", "");
                    if(! subjectListPage.SelectSubject(Subject, "1"))
                    {
                        ReportProvider.getTest().log(LogStatus.FAIL, " Subject not found : " +Subject);
                        continue;
                    }
                    ReportProvider.getTest().log(LogStatus.INFO, " Select Subject : " + Subject);
                    Thread.sleep(2000);
                    visitPage.SelectVisit(Visit);
                    String Section = headers.get(6);
                    visitPage.SelectSection(Section);
                    Thread.sleep(2000);
                    for (int i = 7; i < Data.size(); i++) {

                        try {
                                String InputData = Data.get(i);
                                String ControlType = "";
                                String Question = headers.get(i);

                                if (Question.contains("_") & Question.matches(".*._\\d*\\d$")) {
                                    tableContent = false;
                                    if (InputData != "") {

                                        String quest = Question.substring(0, Question.lastIndexOf("_"));
                                        visitPage.AnswerTheQuestion(quest, InputData, "");
                                        ReportProvider.getTest().log(LogStatus.INFO, "Enter Data for : " + quest );
                                        //ReportProvider.GenerateSnapshotReport(driver, visitPage.currentQuestion);
                                    }
                                }
                                else if(Question.equals("Row No"))
                                {
                                    tableContent = true;
                                }
                                else if(tableContent)
                                {
                                    if (InputData != "") {
                                        visitPage.AnswerTheQuestion(Question, InputData, "Grid");
                                    }
                                    else if(visitPage.IsSection(Question))
                                    {
                                        tableContent = false;
                                    }
                                }
                                else {
                                    visitPage.saveChanges();
                                    visitPage.SelectSection(Question);
                                    ReportProvider.getTest().log(LogStatus.INFO, "Section : " + Question );
                                    Thread.sleep(1000);
                                }

                        }catch (Exception ex)
                        {
                            ReportProvider.getTest().log(LogStatus.FAIL, " Error entering data in column : " +headers.get(i));
                        }
                    }
                }catch (Exception ex)
                {
                    ReportProvider.getTest().log(LogStatus.ERROR, " Error entering data in row : " + nRow +"." );
                }
            }
        }
    }
}


