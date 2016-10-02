package clindox.com.utils;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

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
}
