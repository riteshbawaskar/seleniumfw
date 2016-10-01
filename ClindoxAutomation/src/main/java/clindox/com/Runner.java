package clindox.com;


import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/Result"},
        features = "src/test/java/clindox/com/feature"
)
public class Runner {
}
