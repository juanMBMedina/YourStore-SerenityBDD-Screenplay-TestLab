package us.opencart.hooks;

import io.cucumber.java.Before;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Hooks {

    @Managed
    WebDriver browser;

    @Before
    public void setUp() {
        setTheStage(new OnlineCast());
        theActorCalled("Juan").can(BrowseTheWeb.with(browser));
    }

}
