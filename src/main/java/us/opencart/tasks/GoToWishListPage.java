package us.opencart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import us.opencart.ui.HomePage;

public class GoToWishListPage implements Task {

    public static GoToWishListPage run() {
        return Tasks.instrumented(GoToWishListPage.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(
                Click.on(HomePage.WISH_LIST_NAV_BAR)
        );
    }
}
