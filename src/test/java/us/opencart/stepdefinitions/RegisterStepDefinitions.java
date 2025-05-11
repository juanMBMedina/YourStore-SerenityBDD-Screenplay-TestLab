package us.opencart.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import us.opencart.builders.RegisterUserBuilder;
import us.opencart.models.RegisterUser;
import us.opencart.tasks.FillRegisterForm;
import us.opencart.tasks.GoToRegisterPage;
import us.opencart.ui.HomePage;
import us.opencart.ui.RegisterPage;
import us.opencart.utils.UiAssertions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static us.opencart.utils.TestDataLoader.loadExistUserRegister;
import static us.opencart.utils.TestDataLoader.loadExistUserWithoutPrivacyRegister;

public class RegisterStepDefinitions {

    public static final String LABEL_NEW_USER = "newUserData";

    @Given("the user is on the registration page of Your Store")
    public void theUserIsOnTheRegistrationPageOfYourStore() {
        theActorInTheSpotlight().wasAbleTo(
                Open.url(HomePage.getBaseUrl()),
                GoToRegisterPage.run()
        );
    }

    @Given("the user can create a random user")
    public void theUserCanCreateARandomUser() {
        theActorInTheSpotlight().remember(LABEL_NEW_USER, RegisterUserBuilder.registerAnUser(Boolean.TRUE, Boolean.TRUE));
    }

    @Given("the user enters the random user's data")
    public void theUserEntersTheRandomUserSData() {
        RegisterUser newUser = (RegisterUser) theActorInTheSpotlight().recall(LABEL_NEW_USER);
        theActorInTheSpotlight().wasAbleTo(FillRegisterForm.with(newUser));
    }

    @When("the user submits the registration form")
    public void theUserSubmitsTheRegistrationForm() {
        theActorInTheSpotlight().wasAbleTo(Click.on(RegisterPage.SUBMIT_BUTTON));
    }

    @Then("the user should see a successful registration message")
    public void theUserShouldSeeASuccessfulRegistrationMessage() {
        UiAssertions.shouldSeeTextOnPage(theActorInTheSpotlight(), RegisterPage.SUCCESS_REGISTER_MESSAGE);
    }

    @Given("the user enters an existing user in a test file")
    public void theUserEntersAnExistingUserInATestFile() {
        theActorInTheSpotlight().wasAbleTo(FillRegisterForm.with(loadExistUserRegister()));
    }

    @Then("the user should see a user already exists error message")
    public void theUserShouldSeeAUserAlreadyExistsErrorMessage() {
        UiAssertions.shouldSeeTextOnPage(theActorInTheSpotlight(), RegisterPage.USER_EXIST_MESSAGE);
    }

    @Given("the user enters an existing user with empty params")
    public void theUserEntersAnExistingUserWithEmptyParams(RegisterUser user) {
        theActorInTheSpotlight().wasAbleTo(FillRegisterForm.with(user));
    }

    @Then("the user should see an error message {string} is void")
    public void theUserShouldSeeAnErrorMessageIsVoid(String paramUserRegister) {
        UiAssertions.shouldSeeTextOnPage(theActorInTheSpotlight(), RegisterPage.WITHOUT_PARAMS_MESSAGES.get(paramUserRegister));
    }

    @Given("the user enters an existing user in a test file without privacy")
    public void theUserEntersAnExistingUserInATestFileWithoutPrivacy() {
        theActorInTheSpotlight().wasAbleTo(FillRegisterForm.with(loadExistUserWithoutPrivacyRegister()));
    }

    @Then("the user should see a an error message when the register form doesn't have a privacy check OK")
    public void theUserShouldSeeAAnErrorMessageWhenTheRegisterFormDoesnTHaveAPrivacyCheckOK() {
        UiAssertions.shouldSeeTextOnPage(theActorInTheSpotlight(), RegisterPage.WITHOUT_PRIVACY_MESSAGE);
    }
}
