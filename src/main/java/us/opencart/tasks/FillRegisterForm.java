package us.opencart.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.targets.Target;
import us.opencart.models.RegisterUser;
import us.opencart.ui.RegisterUI;

@AllArgsConstructor
public class FillRegisterForm implements Task {

    private final RegisterUser user;

    public static FillRegisterForm with(RegisterUser user) {
        return Tasks.instrumented(FillRegisterForm.class, user);
    }

    private static void writeInput(Actor actor, Target inputTextField, String text) {
        actor.wasAbleTo(
                Clear.field(inputTextField),
                SendKeys.of(text).into(inputTextField)
        );
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        writeInput(actor, RegisterUI.INPUT_TEXT_FIRST_NAME, user.getFirstName());
        writeInput(actor, RegisterUI.INPUT_TEXT_LAST_NAME, user.getLastName());
        writeInput(actor, RegisterUI.INPUT_TEXT_EMAIL, user.getEmail());
        writeInput(actor, RegisterUI.INPUT_TEXT_TELEPHONE, user.getTelephone());
        writeInput(actor, RegisterUI.INPUT_TEXT_PASSWORD, user.getPassword());
        writeInput(actor, RegisterUI.INPUT_TEXT_PASSWORD_CONFIRM, user.getPasswordConfirm());

        actor.wasAbleTo(
                Click.on(RegisterUI.getSubscribeTarget.apply(user.getSubscribe()))
        );

        if (user.getPrivacy()) {
            actor.wasAbleTo(CheckCheckbox.of(RegisterUI.CHECK_BOX_PRIVACY));
        } else {
            actor.wasAbleTo(UncheckCheckbox.of(RegisterUI.CHECK_BOX_PRIVACY));
        }
    }
}
