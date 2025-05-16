package us.opencart.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import us.opencart.exceptions.OptionNotFoundException;
import us.opencart.ui.HomeUI;

import static us.opencart.ui.HomeUI.*;

@AllArgsConstructor
public class NavigateTo implements Task {

    private final String option;

    private static NavigateTo run(String option) {
        return Tasks.instrumented(NavigateTo.class, option);
    }

    public static NavigateTo addToCart() {
        return run(ADD_TO_CART_OPTION);
    }

    public static NavigateTo wishList() {
        return run(WISH_LIST_OPTION);
    }

    public static NavigateTo login() {
        return run(LOGIN_OPTION);
    }

    public static NavigateTo register() {
        return run(REGISTER_OPTION);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (option) {
            case LOGIN_OPTION:
                actor.wasAbleTo(
                        Click.on(HomeUI.My_ACC_TOP_NAV_BAR),
                        Click.on(HomeUI.LOGIN_OPT_NAV_BAR)
                );
                break;
            case REGISTER_OPTION:
                actor.wasAbleTo(
                        Click.on(HomeUI.My_ACC_TOP_NAV_BAR),
                        Click.on(HomeUI.REGISTER_NAV_BAR)
                );
                break;
            case WISH_LIST_OPTION:
                actor.wasAbleTo(
                        Click.on(HomeUI.WISH_LIST_NAV_BAR)
                );
                break;
            case ADD_TO_CART_OPTION:
                actor.wasAbleTo(
                        Click.on(HomeUI.ADD_TO_CART_NAV_BAR)
                );
                break;
            default:
                throw new OptionNotFoundException(option);
        }
    }
}
