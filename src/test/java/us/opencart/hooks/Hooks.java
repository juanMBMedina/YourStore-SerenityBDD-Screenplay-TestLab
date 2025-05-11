package us.opencart.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;
import us.opencart.builders.RegisterUserBuilder;
import us.opencart.models.RegisterUser;
import us.opencart.models.SearchItemNavBar;

import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static us.opencart.models.SearchItemNavBar.DEFAULT_VALUE;

public class Hooks {

    @Managed
    WebDriver browser;

    @Before
    public void setUp() {
        setTheStage(new OnlineCast());
        theActorCalled("Juan").can(BrowseTheWeb.with(browser));
    }

    @DataTableType
    public RegisterUser DataToUserRegister(Map<String, String> data) {
        return RegisterUserBuilder.registerAnUser(data);
    }

    @DataTableType
    public SearchItemNavBar toItemNavBar(Map<String, String> data) {
        return new SearchItemNavBar(
                data.get("category"),
                data.getOrDefault("subcategory", DEFAULT_VALUE),
                data.get("itemName"));
    }

}
