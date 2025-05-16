package us.opencart.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.Text;
import us.opencart.exceptions.TestDataLoadException;
import us.opencart.questions.ShouldThrow;
import us.opencart.tasks.FillLoginForm;
import us.opencart.tasks.NavigateTo;
import us.opencart.tasks.LogOutUser;
import us.opencart.ui.HomeUI;
import us.opencart.ui.LoginUI;
import us.opencart.utils.TestDataLoader;
import us.opencart.utils.UiAssertions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static us.opencart.ui.HomeUI.ITEM_CONTAINS_TEXT;

public class LoginStepDefinitions {

    @Given("the user is on the login page of Your Store")
    public void theUserIsOnTheLoginPageOfYourStore() {
        theActorInTheSpotlight().wasAbleTo(
                Open.url(HomeUI.getBaseUrl()),
                NavigateTo.login()
        );
    }

    @Given("the user enters credentials with test file")
    public void theUserEntersCredentialsWithTestFile() {
        theActorInTheSpotlight().wasAbleTo(
                FillLoginForm.with(TestDataLoader.loadCorrectUserLogin())
        );
    }

    @When("the user submits the login form")
    public void theUserSubmitsTheLoginForm() {
        theActorInTheSpotlight().wasAbleTo(Click.on(LoginUI.SUBMIT_BUTTON));
    }

    @Then("the user should see a successful login message")
    public void theUserShouldSeeASuccessfulLoginMessage() {
        theActorInTheSpotlight().should(
                seeThat(Text.ofEach(LoginUI.LOGIN_SUCCESS_TITLES),
                        containsInAnyOrder(LoginUI.EXPECTED_HEADERS.toArray()
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
        UiAssertions.shouldSeeTextOnPage(theActorInTheSpotlight(), LoginUI.LOGOUT_MESSAGE);
    }

    @Given("the user enters credentials with username {string} and password {string}")
    public void theUserEntersCredentialsWithUsernameAndPassword(String email, String password) {
        theActorInTheSpotlight().wasAbleTo(FillLoginForm.with(email, password));
    }

    @Then("the user should see a unsuccessful login message")
    public void theUserShouldSeeAUnsuccessfulLoginMessage() {
        UiAssertions.shouldSeeTextOnPage(theActorInTheSpotlight(), LoginUI.LOGIN_WRONG_MESSAGE);
    }

    @When("the user sends credentials with username {string} and password {string} for {int} attempts")
    public void theUserSendsCredentialsWithUsernameAndPasswordForAttempts(String email, String password, Integer count) {
        Actor tempActor = theActorInTheSpotlight();
        int attemp = 0;
        do {
            theUserEntersCredentialsWithUsernameAndPassword(email, password);
            theUserSubmitsTheLoginForm();
            attemp++;
        } while (attemp < count && ITEM_CONTAINS_TEXT.of(LoginUI.LOGIN_WRONG_MESSAGE).resolveFor(tempActor).isVisible());
    }

    @Then("the user should see an error message indicating that the maximum number of login attempts has been reached")
    public void theUserShouldSeeAnErrorMessageIndicatingThatTheMaximumNumberOfLoginAttemptsHasBeenReached() {
        UiAssertions.shouldSeeTextOnPage(theActorInTheSpotlight(), LoginUI.MAX_LOGIN_MESSAGE);
    }

    @Then("the user should see an error exception in the Data Loader")
    public void theUserShouldSeeAnErrorExceptionInTheDataLoader() {
        theActorInTheSpotlight().should(
                seeThat(ShouldThrow.whenExecuting(TestDataLoader::loadWrongLabelUserLogin, TestDataLoadException.class))
        );
        theActorInTheSpotlight().should(
                seeThat(ShouldThrow.whenExecuting(TestDataLoader::loadKeyDoesNotExistUserLogin, IllegalArgumentException.class))
        );

    }

}
