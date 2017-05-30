package clindox.com.pages;


import clindox.com.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.System.in;

public class InputDataPage extends BasePage {

    @FindBy(xpath = "//table[@id='ctl00_ContentPlaceHolder1_grdManageList']")
    WebElement InputgridList;

    @FindBy(xpath="//table[@id='ctl00_ContentPlaceHolder1_grdManageList']/tbody/tr")
    public List<WebElement> InputgridListRows;

    public boolean gotoSubjects(String Study) throws Exception
    {
        for(WebElement row: InputgridListRows)
        {
            if(row.getText().contains(Study))
            {
                WebElement actionbtn = row.findElement(By.xpath(".//img[contains(@src,'Setting_Icon')]"));
                actionbtn.click();
                //WaitforElement(By.xpath(".//a[contains(@id,'SelectRecord')]"));
                Thread.sleep(1000);
                WebElement subjects = row.findElement(By.xpath(".//a[contains(@id,'SelectRecord1')]"));
                subjects.click();
                return true;
            }
        }
        return false;
    }
}
