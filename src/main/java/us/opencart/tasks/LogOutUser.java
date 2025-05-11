package us.opencart.tasks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import us.opencart.exceptions.OptionNotFoundException;
import us.opencart.ui.LoginPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;


@Getter
@AllArgsConstructor
public class LogOutUser implements Task {

    private static final String TOP_NAV_BAR_OPT = "topNavBar";
    private static final String RIGHT_MENU_OPT = "rightMenu";
    private final String option;

    private static LogOutUser run(String option) {
        return instrumented(LogOutUser.class, option);
    }

    public static LogOutUser withNavBar() {
        return run(TOP_NAV_BAR_OPT);
    }

    public static LogOutUser withRightMenu() {
        return run(RIGHT_MENU_OPT);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (getOption().equals(TOP_NAV_BAR_OPT)) {
            actor.wasAbleTo(
                    Click.on(LoginPage.My_ACC_TOP_NAV_BAR),
                    Click.on(LoginPage.LOGOUT_OPT_NAV_BAR)
            );
        } else if (getOption().equals(RIGHT_MENU_OPT)) {
            actor.wasAbleTo(
                    Click.on(LoginPage.My_ACC_TOP_NAV_BAR),
                    Click.on(LoginPage.LOGOUT_OPT_RIGHT_MENU)
            );
        }else{
            throw new OptionNotFoundException(option);
        }
    }
}
