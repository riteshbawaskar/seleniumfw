package clindox.com.utils;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class ReportProvider {

    public static ExtentReports extentReports;
    public static ExtentTest test;
    public static ConfigProvider configProvider = new ConfigProvider();

    public static ExtentReports getReporter()
    {
        if(extentReports == null)
        {
            String Reportpath = configProvider.getConfiguration("resultfile");
            extentReports = new ExtentReports(Reportpath);
        }
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
            final ByteArrayOutputStream os = new ByteArrayOutputStream();
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            int ImageHeight = element.getSize().getHeight();
            int ImageWidth = element.getSize().getWidth();

            JavascriptExecutor executor = (JavascriptExecutor) driver;
            Long value = (Long) executor.executeScript("return window.pageYOffset;");

            int x = element.getLocation().getX();
            int y = element.getLocation().getY();

            if(value > 0) y= y - value.intValue();

            BufferedImage img = ImageIO.read(screenshot);
            BufferedImage dest = img.getSubimage(x, y, ImageWidth, ImageHeight);
            ImageIO.write(dest, "png", Base64.getEncoder().wrap(os));
            String base64 =  os.toString(StandardCharsets.ISO_8859_1.name());
            test.log(LogStatus.INFO,"<Img src='data:image/png;base64,"+base64+ "'/>" );
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static void GenerateSnapshotReport(WebDriver driver)
    {
        try {
            final ByteArrayOutputStream os = new ByteArrayOutputStream();
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage dest = ImageIO.read(screenshot);
            ImageIO.write(dest, "png", Base64.getEncoder().wrap(os));
            String base64 =  os.toString(StandardCharsets.ISO_8859_1.name());
            test.log(LogStatus.INFO,"<Img src='data:image/png;base64,"+base64+ "'/>" );
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
