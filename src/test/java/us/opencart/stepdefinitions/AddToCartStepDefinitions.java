package us.opencart.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.questions.Text;
import us.opencart.models.SearchItemNavBar;
import us.opencart.tasks.GoToLoginPage;
import us.opencart.tasks.GoToWishListPage;
import us.opencart.tasks.SearchItem;
import us.opencart.tasks.SelectOptionOfItem;
import us.opencart.ui.HomePage;
import us.opencart.ui.WishListPage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class AddToCartStepDefinitions {

    public static final String ITEM_NAME_LABEL = "itemName";

    @Given("the user searches for an item in the navigation bar")
    public void theUserSearchesForAnItemInTheNavigationBar(SearchItemNavBar itemData) {
        theActorInTheSpotlight().wasAbleTo(SearchItem.with(itemData));
        theActorInTheSpotlight().remember(ITEM_NAME_LABEL, itemData.getItemName());
    }

    @When("the user clicks the {string} link for the item")
    public void theUserClicksTheLinkForTheItem(String optionItem) {
        String itemName = theActorInTheSpotlight().recall(ITEM_NAME_LABEL);
        theActorInTheSpotlight().wasAbleTo(SelectOptionOfItem.with(itemName, optionItem));
    }

    @Then("the user should see a successful comparison item message")
    public void theUserShouldSeeASuccessfulComparisonItemMessage() {
        String itemName = theActorInTheSpotlight().recall(ITEM_NAME_LABEL);
        String expectedText = String.format(HomePage.COMPARISON_SUCCESS_MESSAGE, itemName);
        theActorInTheSpotlight().should(
                seeThat(Text.of(HomePage.ALERT_MESSAGE_TARGET), containsString(expectedText))
        );
    }

    @Then("the user should see a successful item added to the Wish List message")
    public void theUserShouldSeeASuccessfulItemAddedToTheWishListMessage() {
        String itemName = theActorInTheSpotlight().recall(ITEM_NAME_LABEL);
        String expectedText = String.format(HomePage.WISH_LIST_SUCCESS_MESSAGE, itemName);
        theActorInTheSpotlight().should(
                seeThat(Text.of(HomePage.ALERT_MESSAGE_TARGET), containsString(expectedText))
        );
    }
    @Then("the user is on the Wish List page")
    public void theUserIsOnTheWishListPage() {
        theActorInTheSpotlight().wasAbleTo(GoToWishListPage.run());
    }
    @Then("the user should see the selected item in the Wish List")
    public void theUserShouldSeeTheSelectedItemInTheWishList() {
        String itemName = theActorInTheSpotlight().recall(ITEM_NAME_LABEL);
        theActorInTheSpotlight().should(
                seeThat(Text.of(WishListPage.ITEM_NAME_TABLE.of(itemName)), containsString(itemName))
        );
    }
}
