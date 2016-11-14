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

    @FindBy(xpath="//div[@class='questions-list-title']")
    public List<WebElement> QuestionList;
    public WebElement currentQuestion;

    @FindBy(xpath="//a[contains(text(), 'Save Changes')]")
    public WebElement savechanges;

    @FindBy(xpath="//a[contains(text(), 'Save Change and Next')]")
    public WebElement savechangesandnext;

    @FindBy(xpath="//a/img[@id='you tube']/@src")
    public WebElement returntosubject;


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
            return false;}
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
        //ul[@class='nav nav-tabs nav-stacked nav-visits']//span[@title='Visit 1 Checklist: Initial Baseline Assessment']
        //ul[@class='nav nav-tabs nav-stacked nav-visits']//span[@title='Visit 1 Checklist: Initial Baseline Assessment']/../../ul/li[1]
        String visitxpath = "//ul[@class='nav nav-tabs nav-stacked nav-visits']//span[@title='"+ visitName +"']";
        String firstsection = "//ul[@class='nav nav-tabs nav-stacked nav-visits']//span[@title='"+ visitName +"']/../../ul/li[1]";

        WebElement element =  driver.findElement(By.xpath(visitxpath));
        element.click();
        WebElement sectionelement =  driver.findElement(By.xpath(firstsection));
        sectionelement.click();
    }

    public void SelectSection(String section)
    {
        String sectionxpath = "//div[@id='ctl00_ContentPlaceHolder1_divSectionTitle']/a";
        String sectionselectxpath = "//div[@id='ctl00_ContentPlaceHolder1_divSectionTitle']/ul//a[contains(text(),'"+section+"')]";

        WebElement element =  driver.findElement(By.xpath(sectionxpath));
        element.click();
        WebElement sectionelement =  driver.findElement(By.xpath(sectionselectxpath));
        sectionelement.click();
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




}
