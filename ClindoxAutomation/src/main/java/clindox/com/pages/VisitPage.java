package clindox.com.pages;
import clindox.com.utils.BasePage;
import clindox.com.utils.ReportProvider;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VisitPage extends BasePage{

    @FindBy(xpath="//div[@class='questions-list-title']")
    public List<WebElement> QuestionList;
    public WebElement currentQuestion;

    WebDriver driver;

    public void SetWebDriver(WebDriver driver)
    {
        this.driver = driver;
    }

    public boolean AnswerTheQuestion(String Question, String Answer, String ControlType)
    {
        for(WebElement questionrow: QuestionList)
        {
            if(questionrow.getText().contains(Question))
            {
                currentQuestion = questionrow;
                if(ControlType.equals("Input")) {
                    WebElement input = questionrow.findElement(By.xpath(".//input[@type='text']"));
                    input.sendKeys(Answer);
                    input.sendKeys(Keys.TAB);

                }
                else if(ControlType.equals("TextArea"))
                    questionrow.findElement(By.xpath(".//textarea")).sendKeys(Answer);
                else if(ControlType.equals("Select"))
                    questionrow.findElement(By.xpath(".//select")).sendKeys(Answer);
                else if(ControlType.equals("Option"))
                    questionrow.findElement(By.xpath(".//label[text()='"+ Answer +"']/preceding-sibling::input[@type='radio']")).click();
                else if(ControlType.equals("Checkbox"))
                {
                    for(String ans: Answer.split(","))
                    {
                        questionrow.findElement(By.xpath(".//label[text()='"+ ans +"']/preceding-sibling::input[@type='checkbox']")).click();
                    }
                }
                else if(ControlType.equals("Slider"))
                {
                    WebElement slider = questionrow.findElement(By.xpath(".//input[@type='range']"));
                    String id = slider.getAttribute("id");
                    String name = slider.getAttribute("name");
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("javascript:document.evaluate(\"//input[@id='"+ id + "']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.value="+Answer+";");
                    js.executeScript("javascript:document.evaluate(\"//input[@id='"+ id + "']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.oninput();");

                }

                return true;
            }
        }
        return false;
    }

    public void SetSliderValue(String value)
    {

    }

}
