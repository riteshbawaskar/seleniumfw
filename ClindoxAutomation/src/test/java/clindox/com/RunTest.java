package clindox.com;


import clindox.com.utils.ReportProvider;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/Destination"},
        features = "src/test/java/clindox/com/feature" ,
       tags = {"@input,@output"}
)
public class RunTest {


}
