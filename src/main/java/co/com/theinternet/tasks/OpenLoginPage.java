package co.com.theinternet.tasks;

import co.com.theinternet.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenLoginPage implements Task {

    public static OpenLoginPage open() {
        return new OpenLoginPage();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(LoginPage.URL));
    }
}