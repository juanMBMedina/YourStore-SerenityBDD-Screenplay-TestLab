package co.com.theinternet.stepdefinitions;

import co.com.theinternet.questions.SecureAreaMessage;
import co.com.theinternet.tasks.Login;
import co.com.theinternet.tasks.OpenLoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class LoginExampleStepDefinitions {

    @Managed
    WebDriver browser;

    Actor user = Actor.named("User");

    @Before
    public void setUp() {
        user.can(BrowseTheWeb.with(browser));
    }

    @Given("the user opens the login page")
    public void theUserOpensTheLoginPage() {
        user.attemptsTo(OpenLoginPage.open());
    }

    @When("the user logs in with username {string} and password {string}")
    public void theUserLogsIn(String username, String password) {
        user.attemptsTo(Login.withCredentials(username, password));
    }

    @Then("the user should see the secure area")
    public void theUserShouldSeeTheSecureArea() {
        user.should(seeThat(SecureAreaMessage.isVisible(), is(true)));
    }
}
