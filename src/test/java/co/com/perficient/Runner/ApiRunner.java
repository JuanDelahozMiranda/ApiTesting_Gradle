package co.com.perficient.Runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/Features/Services_rest.feature",
                 glue = "co/com/perficient/StepDefinition",
                 snippets = CucumberOptions.SnippetType.CAMELCASE,
                 tags = "@Service2")

public class ApiRunner {
}
