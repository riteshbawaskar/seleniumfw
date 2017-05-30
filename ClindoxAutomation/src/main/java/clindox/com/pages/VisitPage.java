package clindox.com.pages;
import clindox.com.utils.BasePage;
import clindox.com.utils.ExcelReader;
import clindox.com.utils.ReportProvider;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VisitPage extends BasePage{

    @FindBy(xpath="//div[contains(@id,'ctl00_ContentPlaceHolder1_rptQuestion')]")
    public List<WebElement> QuestionList;
    public WebElement currentQuestion;

    @FindBy(xpath="//a[contains(text(), 'Save Changes')]")
    public WebElement savechanges;

    @FindBy(xpath="//a[contains(text(), 'Save Change and Next')]")
    public WebElement savechangesandnext;

    @FindBy(xpath="//a/img[@id='you tube']/@src")
    public WebElement returntosubject;

    @FindBy(xpath="//div[@class='card-panel pDetails']/div[@class='row test-study-options']//div[@class='col s5 m5']/div[@class='input-field col s12 dropdown-holder']//input[@class='select-dropdown']")
    public WebElement visitDropdown;

    @FindBy(xpath="//div[@class='row test-study-options']//div[@class='col s5 m5']/div[@class='input-field col s12 dropdown-holder']//ul[contains(@id,'select-options')]/li")
    public List<WebElement> visitList;

    @FindBy(xpath="//div[@class='card-panel pDetails']/div[@class='row section-container']//div[@class='row setting-cards']//div[@class='select-wrapper initialized']//input[@class='select-dropdown']")
    public WebElement sectionDropdown;

    @FindBy(xpath="//div[@class='card-panel pDetails']/div[@class='row section-container']//div[@class='row setting-cards']//div[@class='select-wrapper initialized']//ul[contains(@id,'select-option')]//li")
    public List<WebElement> sectionList;

    WebDriver driver;

    public void SetWebDriver(WebDriver driver)
    {
        this.driver = driver;
    }

    public boolean saveChanges() throws  Exception
    {
        savechanges.click();
        Thread.sleep(1000);

        String resultxpath = "//div[@id='ctl00_ContentPlaceHolder1_ErrorMsgQuestion']";

        try {
            WaitforElement(By.xpath(resultxpath));
        }
        catch (Exception ex){
            return false;
        }
        WebElement element =  driver.findElement(By.xpath(resultxpath));
        if(element.getText().contains("Data Saved Successfully"))
            return true;
        else
            return false;
    }

    public void Returntosubject()
    {
        returntosubject.click();
    }

    public void SelectVisit(String visitName)
    {
        visitDropdown.click();
        for(WebElement element : visitList) {
            if(element.getText().contains(visitName))
                element.click();
        }

    }

    public void SelectVisit(String visitName, String SectionName) {

        visitDropdown.click();
        for (WebElement element : visitList) {
            if (element.getText().contains(visitName))
                element.click();
        }

        sectionDropdown.click();
        for(WebElement element : sectionList) {
            if(element.getText().contains(SectionName))
                element.click();
        }

    }

    public void SelectSection(String section)
    {
        sectionDropdown.click();
        for(WebElement element : sectionList) {
            if(element.getText().contains(section))
                element.click();
        }
    }

    public boolean IsSection(String section) throws Exception
    {
        String sectionxpath = "//div[@id='ctl00_ContentPlaceHolder1_divSectionTitle']/a";
        String sectionselectxpath = "//div[@id='ctl00_ContentPlaceHolder1_divSectionTitle']/ul//a[contains(text(),'"+section+"')]";

        List<WebElement> element =  driver.findElements(By.xpath(sectionxpath));
        if(element.size() > 0)
        {
            saveChanges();
            WebElement sectionelement =  driver.findElement(By.xpath(sectionxpath));
            sectionelement.click();
            return true;
        }
        else
            return false;
    }

    private String lookupControlType(WebElement section)
    {
        List<WebElement> elements  = section.findElements(By.xpath(".//input[@type='range']"));
        if(elements.size() > 0)return "Slider";

        elements  = section.findElements(By.xpath(".//input[@type='text']"));
        if(elements.size() > 0)return "Input";

        elements  = section.findElements(By.xpath(".//input[@type='checkbox']"));
        if(elements.size() > 0)return "Checkbox";

        elements  = section.findElements(By.xpath(".//textarea"));
        if(elements.size() > 0)return "TextArea";

        elements  = section.findElements(By.xpath(".//select"));
        if(elements.size() > 0)return "Select";

        elements  = section.findElements(By.xpath(".//input[@type='radio']"));
        if(elements.size() > 0)return "Option";

        return "Input";
    }

    public boolean AnswerTheQuestion(String Question, String Answer, String ControlType, String strid) throws Exception
    {
        for(WebElement questionrow: QuestionList)
        {
            boolean isquestionsection = false;
            if(strid!="") {
                WebElement input = questionrow.findElement(By.xpath(".//input[@type='hidden']"));
                if(input.getAttribute("value").contains(strid))
                    isquestionsection = true;
                else
                    isquestionsection = false;
            }
            else if(ControlType.equals("Grid") )
            {
                if(questionrow.getText().contains("\n"+Question.trim()))
                isquestionsection = true;
            }
            else if(questionrow.getText().startsWith(Question.trim()))
            {
                isquestionsection = true;
            }

            if(isquestionsection)
            {
                currentQuestion = questionrow;

                if(ControlType == "") ControlType = lookupControlType(questionrow);
                if(ControlType.equals("Grid"))
                {
                    WebElement input = questionrow.findElement(By.xpath(".//table//tr//span[contains(text(),'" +Question+"')]/../.. "));
                    ControlType = lookupControlType(input);
                    questionrow = input;

                }

                if(ControlType.equals("Input")) {
                    WebElement input = questionrow.findElement(By.xpath(".//input[@type='text']"));
                    if(input.isEnabled()) {
                        input.sendKeys(Answer);
                        Thread.sleep(1000);
                        input.sendKeys(Keys.TAB);
                    }
                    else
                    {
                        ReportProvider.getTest().log(LogStatus.FAIL," Input disabled : " + Question);
                    }

                }
                else if(ControlType.equals("TextArea")) {

                    WebElement input = questionrow.findElement(By.xpath(".//textarea"));
                    if(input.isEnabled()) {
                     input.sendKeys(Answer);
                    }
                    else
                    {
                        ReportProvider.getTest().log(LogStatus.FAIL," Input disabled : " + Question);
                    }


                }
                else if(ControlType.equals("Select")) {
                    WebElement input = questionrow.findElement(By.xpath(".//select"));
                    if(input.isEnabled())
                    {
                        input.sendKeys(Answer);
                    }
                    else
                    {
                        ReportProvider.getTest().log(LogStatus.FAIL," Input disabled : " + Question);
                    }
                }

                else if(ControlType.equals("Option")) {
                    WebElement input = questionrow.findElement(By.xpath(".//label[text()='" + Answer + "']/preceding-sibling::input[@type='radio']"));
                    if(input.isEnabled()) {
                        input.click();
                    }
                    else
                    {
                        ReportProvider.getTest().log(LogStatus.FAIL," Input disabled : " + Question);
                    }

                }
                else if(ControlType.equals("Checkbox"))
                {
                    for(String ans: Answer.split(","))
                    {
                        WebElement input = questionrow.findElement(By.xpath(".//label[text()='"+ ans +"']/preceding-sibling::input[@type='checkbox']"));
                        if(input.isEnabled()) {
                            input.click();
                        }
                        else
                        {
                            ReportProvider.getTest().log(LogStatus.FAIL," Input disabled : " + Question);
                        }
                    }
                }
                else if(ControlType.equals("Slider"))
                {
                    WebElement slider = questionrow.findElement(By.xpath(".//input[@type='range']"));
                    if(slider.isEnabled()) {
                        String id = slider.getAttribute("id");
                        String name = slider.getAttribute("name");
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js.executeScript("javascript:document.evaluate(\"//input[@id='" + id + "']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.value=" + Answer + ";");
                        js.executeScript("javascript:document.evaluate(\"//input[@id='" + id + "']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.oninput();");
                    }
                    else
                    {
                        ReportProvider.getTest().log(LogStatus.FAIL," Input disabled : " + Question);
                    }
                }

                return true;
            }
        }
        return false;
    }


    public boolean ValidateAnswer(String Question, String Answer, String ControlType, String strid) throws Exception
    {
        for(WebElement questionrow: QuestionList)
        {
            boolean isquestionsection = false;
            if(strid!="") {
                WebElement input = questionrow.findElement(By.xpath(".//input[@type='hidden']"));
                if(input.getAttribute("value").contains(strid))
                    isquestionsection = true;
                else
                    isquestionsection = false;
            }
            else if(ControlType.equals("Grid") )
            {
                if(questionrow.getText().contains("\n"+Question.trim()))
                    isquestionsection = true;
            }
            else if(questionrow.getText().startsWith(Question.trim()))
            {
                isquestionsection = true;
            }

            if(isquestionsection)
            {
                currentQuestion = questionrow;

                if(ControlType == "") ControlType = lookupControlType(questionrow);
                if(ControlType.equals("Grid"))
                {
                   // WebElement input = questionrow.findElement(By.xpath(".//table//tr//span[contains(text(),'" +Question+"')]/../.. "));
                   // ControlType = lookupControlType(input);
                   // questionrow = input;

                }

                if(ControlType.equals("Input")) {
                    WebElement input = questionrow.findElement(By.xpath(".//input[@type='text']"));
                    String actualresult = input.getAttribute("value");

                    if(actualresult.equals(Answer)) {
                        ReportProvider.getTest().log(LogStatus.PASS, Question + " : " + Answer);
                    }
                    else
                    {
                        ReportProvider.getTest().log(LogStatus.FAIL,Question + " : " + actualresult  + ". Expected : " + Answer);
                    }

                }
                else if(ControlType.equals("TextArea")) {

                    WebElement input = questionrow.findElement(By.xpath(".//textarea"));
                    String actualresult = input.getText();

                    if(actualresult.equals(Answer)) {
                        ReportProvider.getTest().log(LogStatus.PASS, Question + " : " + Answer);
                    }
                    else
                    {
                        ReportProvider.getTest().log(LogStatus.FAIL,Question + " : " + actualresult  + ". Expected : " + Answer);
                    }


                }
                else if(ControlType.equals("Select")) {
                    WebElement input = questionrow.findElement(By.xpath(".//select"));
                    String actualresult = input.getAttribute("value");

                    if(actualresult.equals(Answer)) {
                        ReportProvider.getTest().log(LogStatus.PASS, Question + " : " + Answer);
                    }
                    else
                    {
                        ReportProvider.getTest().log(LogStatus.FAIL,Question + " : " + actualresult  + ". Expected : " + Answer);
                    }
                }

                else if(ControlType.equals("Option")) {
                    WebElement input = questionrow.findElement(By.xpath(".//label[text()='" + Answer + "']/preceding-sibling::input[@type='radio']"));

                    if(input.isSelected()) {
                        ReportProvider.getTest().log(LogStatus.PASS, Question + " : " + Answer);
                    }
                    else
                    {
                        ReportProvider.getTest().log(LogStatus.FAIL,Question + " : "  + Answer +" not selected.");
                    }

                }
                else if(ControlType.equals("Checkbox"))
                {
                    for(String ans: Answer.split(","))
                    {
                        WebElement input = questionrow.findElement(By.xpath(".//label[text()='"+ ans +"']/preceding-sibling::input[@type='checkbox']"));
                        if(input.isSelected()) {
                            ReportProvider.getTest().log(LogStatus.PASS, Question + " : " + ans);
                        }
                        else
                        {
                            ReportProvider.getTest().log(LogStatus.FAIL,Question + " : "  + ans +" not selected.");
                        }
                    }
                }
                else if(ControlType.equals("Slider"))
                {
                    WebElement slider = questionrow.findElement(By.xpath(".//input[@type='range']"));

                        String id = slider.getAttribute("id");
                        String name = slider.getAttribute("name");
                        String value = slider.getAttribute("value");

                        if(value.equals(Answer)) {
                            ReportProvider.getTest().log(LogStatus.PASS, Question + " : " + Answer);
                        }
                        else
                        {
                            ReportProvider.getTest().log(LogStatus.FAIL,Question + " : " + value  + ". Expected : " + Answer);
                        }
                }

                return true;
            }
        }
        return false;
    }

}
