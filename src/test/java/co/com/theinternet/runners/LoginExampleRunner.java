package co.com.theinternet.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/theinternet/",
        glue = {"co.com.theinternet.stepdefinitions", "co.com.theinternet.hooks"},
        plugin = {"pretty"},
        monochrome = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@example"
)
public class LoginExampleRunner {
}