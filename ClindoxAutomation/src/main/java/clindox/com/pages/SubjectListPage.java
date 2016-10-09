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

public class SubjectListPage extends BasePage{

    @FindBy(xpath="//div[@class='list-block clearfix']")
    public List<WebElement> SubjectList;

    public boolean Selectvisit(String Subject, String Visit)
    {
        WaitforElement(By.xpath("//div[@class='list-block clearfix']"));
        for(WebElement subjectrow: SubjectList)
        {
            if(subjectrow.getText().contains(Subject))
            {
                WaitforElement(By.xpath(".//a[contains(text(), '"+ Visit +"')]"));
                WebElement visitlink =  subjectrow.findElement(By.xpath("//a[contains(text(), '"+ Visit +"')]"));
                visitlink.click();
                return true;
            }
        }
        return false;
    }


}
