package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty", //konsolu renklendirir
                "html:raporlar/CucumberRapor.html",
                "rerun:TestOutput/failed_scenario.txt"
        },

        features = "src/test/resources/features",
        glue = {"stepDefinitions","hooks"},
        tags = "@task12",
        dryRun = false,
        monochrome = false
)

public class Runner {

}
