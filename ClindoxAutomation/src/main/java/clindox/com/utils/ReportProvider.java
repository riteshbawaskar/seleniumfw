package clindox.com.utils;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ReportProvider {

    public static ExtentReports extentReports;
    public static ExtentTest test;
    public static ConfigProvider configProvider = new ConfigProvider();

    public static ExtentReports getReporter()
    {
        String Reportpath = configProvider.getConfiguration("resultfile");
        if(extentReports == null) extentReports = new ExtentReports(Reportpath);
        return extentReports;
    }

    public static void StartTest(String TestName)
    {
        if(extentReports == null) getReporter();
        test = extentReports.startTest(TestName);
    }

    public static void EndTest()
    {
        extentReports.endTest(test);
    }
    public static ExtentTest getTest()
    {
        return test;
    }

    public static void GenerateSnapshotReport(WebDriver driver, WebElement element)
    {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            int ImageHeight = element.getSize().getHeight();
            int ImageWidth = element.getSize().getWidth();

            int x = element.getLocation().x;
            int y = element.getLocation().y;
            BufferedImage img = ImageIO.read(screenshot);
            BufferedImage dest = img.getSubimage(x, y, ImageWidth, ImageHeight);
            ImageIO.write(dest, "png", screenshot);
            FileUtils.copyFile(screenshot, new File("c:\\dev\\" + screenshot.getName()));
            test.log(LogStatus.INFO,"<Img src=' c:\\dev\\"+screenshot.getName()+ "'/>" );
        }
        catch (Exception ex)
        {

        }
    }
}
