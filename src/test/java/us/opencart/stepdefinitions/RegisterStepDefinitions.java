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

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static us.opencart.ui.HomePage.ITEM_CONTAINS_TEXT;

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
        theActorInTheSpotlight().should(
                seeThat(the(ITEM_CONTAINS_TEXT.of(RegisterPage.SUCCESS_REGISTER_MESSAGE)), isVisible())
        );
    }
}
