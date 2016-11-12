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

    public boolean SelectSubject(String Subject, String Visit)
    {
        Subject = "ID: " + Subject;
        WaitforElement(By.xpath("//div[@class='list-block clearfix']"));
        List<WebElement> pages = driver.findElements(By.xpath("//div[@class='pagination pull-right']/ul[@id='uls']//a"));
        if(pages.size() > 0) {
            for (int pageno = 1; pageno <= pages.size(); pageno++) {
                if (pageno != 1) {
                    WebElement link = driver.findElement(By.xpath("//div[@class='pagination pull-right']/ul[@id='uls']//a[text()=" + pageno + "]"));
                    link.click();
                    WaitforElement(By.xpath("//div[@class='list-block clearfix']"));
                    SubjectList = driver.findElements(By.xpath("//div[@class='list-block clearfix']"));
                }

                for (WebElement subjectrow : SubjectList) {
                    if (subjectrow.getText().contains(Subject)) {
                        WaitforElement(By.xpath(".//a[contains(text(), '" + Visit + "')]"));
                        WebElement visitlink = subjectrow.findElement(By.xpath(".//a[contains(text(), '" + Visit + "')]"));
                        visitlink.click();
                        return true;
                    }
                }
            }
        }
        else
        {
            for (WebElement subjectrow : SubjectList) {
                if (subjectrow.getText().contains(Subject)) {
                    WaitforElement(By.xpath(".//a[contains(text(), '" + Visit + "')]"));
                    WebElement visitlink = subjectrow.findElement(By.xpath(".//a[contains(text(), '" + Visit + "')]"));
                    visitlink.click();
                    return true;
                }
            }
        }
        return false;
    }


}
