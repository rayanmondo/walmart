package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"stepDefinitions"},
        tags = "@Movie4",
       plugin = {"pretty", "summary", "json:target/Cucumber.json"}

)
public class TestRunner {
}
