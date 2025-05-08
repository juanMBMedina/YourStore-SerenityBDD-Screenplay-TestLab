package co.com.theinternet.questions;

import co.com.theinternet.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class SecureAreaMessage implements Question<Boolean> {

    public static SecureAreaMessage isVisible() {
        return new SecureAreaMessage();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return LoginPage.SECURE_AREA.resolveFor(actor).isVisible();
    }
}
