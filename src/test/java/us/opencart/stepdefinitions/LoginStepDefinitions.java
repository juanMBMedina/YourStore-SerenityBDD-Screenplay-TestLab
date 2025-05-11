package us.opencart.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.Text;
import us.opencart.tasks.FillLoginForm;
import us.opencart.tasks.GoToLoginPage;
import us.opencart.tasks.LogOutUser;
import us.opencart.ui.HomePage;
import us.opencart.ui.LoginPage;
import us.opencart.utils.TestDataLoader;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static us.opencart.ui.HomePage.ITEM_CONTAINS_TEXT;

public class LoginStepDefinitions {

    @Given("the user is on the login page of Your Store")
    public void theUserIsOnTheLoginPageOfYourStore() {
        theActorInTheSpotlight().wasAbleTo(
                Open.url(HomePage.getBaseUrl()),
                GoToLoginPage.run()
        );
    }

    @Given("the user enters credentials with test file")
    public void theUserEntersCredentialsWithTestFile() {
        theActorInTheSpotlight().wasAbleTo(
                FillLoginForm.with(TestDataLoader.loadCorrectUser())
        );
    }

    @When("the user submits the login form")
    public void theUserSubmitsTheLoginForm() {
        theActorInTheSpotlight().wasAbleTo(Click.on(LoginPage.SUBMIT_BUTTON));
    }

    @Then("the user should see a successful login message")
    public void theUserShouldSeeASuccessfulLoginMessage() {
        theActorInTheSpotlight().should(
                seeThat(Text.ofEach(LoginPage.LOGIN_SUCCESS_TITLES),
                        containsInAnyOrder(LoginPage.EXPECTED_HEADERS.toArray()
                        )
                )
        );
    }

    @When("the user can do logout by Top Bar option")
    public void theUserCanDoLogoutByTopBarOption() {
        theActorInTheSpotlight().wasAbleTo(LogOutUser.withNavBar());
    }

    @When("the user can do logout by Right Bar option")
    public void theUserCanDoLogoutByRightBarOption() {
        theActorInTheSpotlight().wasAbleTo(LogOutUser.withRightMenu());
    }

    @Then("the user should see a successful logout message")
    public void theUserShouldSeeASuccessfulLogoutMessage() {
        theActorInTheSpotlight().should(
                seeThat(the(ITEM_CONTAINS_TEXT.of(LoginPage.LOGOUT_MESSAGE)), isVisible())
        );
    }

    @Given("the user enters credentials with username {string} and password {string}")
    public void theUserEntersCredentialsWithUsernameAndPassword(String email, String password) {
        theActorInTheSpotlight().wasAbleTo(FillLoginForm.with(email, password));
    }

    @Then("the user should see a unsuccessful login message")
    public void theUserShouldSeeAUnsuccessfulLoginMessage() {
        theActorInTheSpotlight().should(
                seeThat(the(ITEM_CONTAINS_TEXT.of(LoginPage.LOGIN_WRONG_MESSAGE)), isVisible())
        );
    }

}
