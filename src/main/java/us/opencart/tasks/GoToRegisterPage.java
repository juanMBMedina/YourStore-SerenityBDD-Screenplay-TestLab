package us.opencart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import us.opencart.ui.HomePage;
import us.opencart.ui.LoginPage;

public class GoToRegisterPage implements Task {

    public static GoToRegisterPage run(){
        return Tasks.instrumented(GoToRegisterPage.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(
                Click.on(HomePage.My_ACC_TOP_NAV_BAR),
                Click.on(HomePage.REGISTER_NAV_BAR)
        );
    }
}
