package us.opencart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import us.opencart.ui.LoginPage;

public class GoToLoginPage implements Task {

    public static GoToLoginPage run(){
        return Tasks.instrumented(GoToLoginPage.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(
                Click.on(LoginPage.My_ACC_TOP_NAV_BAR),
                Click.on(LoginPage.LOGIN_OPT_NAV_BAR)
        );
    }
}
