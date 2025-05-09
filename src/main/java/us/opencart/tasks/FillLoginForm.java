package us.opencart.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.SendKeys;
import us.opencart.models.LoginUser;
import us.opencart.ui.LoginPage;

@AllArgsConstructor
public class FillLoginForm implements Task {

    private final LoginUser user;

    public static FillLoginForm with(LoginUser user){
        return Tasks.instrumented(FillLoginForm.class, user);
    }

    public static FillLoginForm with(String email, String password){
        return Tasks.instrumented(FillLoginForm.class, new LoginUser(email, password));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(
                Clear.field(LoginPage.INPUT_TEXT_EMAIL),
                Clear.field(LoginPage.INPUT_TEXT_PASSWORD),
                SendKeys.of(user.getEmail()).into(LoginPage.INPUT_TEXT_EMAIL),
                SendKeys.of(user.getPassword()).into(LoginPage.INPUT_TEXT_PASSWORD)
        );
    }
}
