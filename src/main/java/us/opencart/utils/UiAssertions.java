package us.opencart.utils;

import net.serenitybdd.screenplay.Actor;
import us.opencart.ui.HomePage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class UiAssertions {

    public static void shouldSeeTextOnPage(Actor actor, String expectedText) {
        // Use this method to validate when the actor needs to see a unique (non-repeated) text on the page.
        actor.should(
                seeThat("The element with text '" + expectedText + "' is visible",
                        the(HomePage.ITEM_CONTAINS_TEXT.of(expectedText)),
                        isVisible())
        );
    }
}

