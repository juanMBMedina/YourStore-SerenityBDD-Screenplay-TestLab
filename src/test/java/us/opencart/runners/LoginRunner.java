package us.opencart.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/us/opencart/",
        glue = {"us.opencart.stepdefinitions", "us.opencart.hooks"},
        plugin = {"pretty"},
        monochrome = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@your_store_login_feature"
)
public class LoginRunner {
}