package us.opencart.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.questions.Text;
import us.opencart.models.SearchItemNavBar;
import us.opencart.tasks.DeleteItemTable;
import us.opencart.tasks.NavigateTo;
import us.opencart.tasks.SearchItem;
import us.opencart.tasks.SelectOptionOfItem;
import us.opencart.ui.AddToCartPage;
import us.opencart.ui.HomePage;
import us.opencart.ui.WishListPage;
import us.opencart.utils.UiAssertions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

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
        theActorInTheSpotlight().wasAbleTo(NavigateTo.wishList());
    }

    @Then("the user should see the selected item in the Wish List")
    public void theUserShouldSeeTheSelectedItemInTheWishList() {
        String itemName = theActorInTheSpotlight().recall(ITEM_NAME_LABEL);
        theActorInTheSpotlight().should(
                seeThat(Text.of(WishListPage.ITEM_NAME_TABLE.of(itemName)), containsString(itemName))
        );
    }

    @When("the user clicks the {string} link for the item called {string} in Wish List page")
    public void theUserClicksTheLinkForTheItemCalledInWishListPage(String option, String itemName) {
        theActorInTheSpotlight().remember(ITEM_NAME_LABEL, itemName);
        theActorInTheSpotlight().wasAbleTo(DeleteItemTable.with(itemName, option));
    }

    @Then("the user should see a message confirming the successful removal from the Wish List")
    public void theUserShouldSeeAMessageConfirmingTheSuccessfulRemovalFromTheWishList() {
        String itemName = theActorInTheSpotlight().recall(ITEM_NAME_LABEL);
        theActorInTheSpotlight().should(
                seeThat(the(WishListPage.ITEM_NAME_TABLE.of(itemName)), not(isVisible()))
        );
        UiAssertions.shouldSeeTextOnPage(theActorInTheSpotlight(), WishListPage.WISH_LIST_SUCCESS_MODIFY_MESSAGE);
    }

    @Then("the user should see a successful Add to Cart item message")
    public void theUserShouldSeeASuccessfulAddToCartItemMessage() {
        String itemName = theActorInTheSpotlight().recall(ITEM_NAME_LABEL);
        String expectedText = String.format(HomePage.ADD_TO_CART_SUCCESS_MESSAGE_FORMAT, itemName);
        theActorInTheSpotlight().should(
                seeThat(Text.of(HomePage.ALERT_MESSAGE_TARGET), containsString(expectedText))
        );
    }

    @Then("the user is on the add to Cart Page")
    public void theUserIsOnTheAddToCartPage() {
        theActorInTheSpotlight().wasAbleTo(NavigateTo.addToCart());
    }

    @Then("the user should see the selected item in the Add to Cart")
    public void theUserShouldSeeTheSelectedItemInTheAddToCart() {
        String itemName = theActorInTheSpotlight().recall(ITEM_NAME_LABEL);
        theActorInTheSpotlight().should(
                seeThat(the(AddToCartPage.ITEM_NAME_TABLE.of(itemName)), isVisible())
        );
    }

    @When("the user clicks the {string} link for the item called {string} in Add to Cart page")
    public void theUserClicksTheLinkForTheItemCalledInAddToCartPage(String option, String itemName) {
        theUserClicksTheLinkForTheItemCalledInWishListPage(option, itemName);
    }

    @Then("the user should see a message confirming the successful removal from the Add to Cart")
    public void theUserShouldSeeAMessageConfirmingTheSuccessfulRemovalFromTheAddToCart() {
        String itemName = theActorInTheSpotlight().recall(ITEM_NAME_LABEL);
        theActorInTheSpotlight().should(
                seeThat(the(AddToCartPage.ITEM_NAME_TABLE.of(itemName)), not(isVisible()))
        );
    }

}
