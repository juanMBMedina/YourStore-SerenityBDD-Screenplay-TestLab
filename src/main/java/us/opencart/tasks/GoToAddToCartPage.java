package us.opencart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import us.opencart.ui.HomePage;

public class GoToAddToCartPage implements Task {

    public static GoToAddToCartPage run() {
        return Tasks.instrumented(GoToAddToCartPage.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(
                Click.on(HomePage.ADD_TO_CART_NAV_BAR)
        );
    }
}
