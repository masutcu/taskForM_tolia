package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty", //konsolu renklendirir
                "html:TestOutput/htmlReport/cucumberHooks.html",
                "json:target/json-reports/cucumber.json",
                "junit:TestOutput/htmlReport/cucumber.xml",
                "rerun:TestOutput/failed_scenario.txt"
        },

        features = "src/test/resources/features",
        glue = "stepDefinitions",
        tags = "@task12",
        dryRun = false,
        monochrome = false
)

public class Runner {

}
