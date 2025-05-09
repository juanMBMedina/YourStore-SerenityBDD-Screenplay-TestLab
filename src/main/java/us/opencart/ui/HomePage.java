package us.opencart.ui;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import us.opencart.exceptions.MissingConfigurationPropertyException;


public class HomePage extends PageObject {

    public static final Target My_ACC_TOP_NAV_BAR = CommonElements.TOP_NAV_ITEM_CONTAINS_TEXT.of("My Account");
    public static final Target LOGIN_TOP_NAV_BAR = CommonElements.TOP_NAV_ITEM_CONTAINS_TEXT.of("Login");

    public static String getBaseUrl() {
        EnvironmentVariables env = SystemEnvironmentVariables.createEnvironmentVariables();
        return EnvironmentSpecificConfiguration.from(env)
                .getOptionalProperty("webdriver.base.url").orElseThrow(
                        () -> new MissingConfigurationPropertyException("webdriver.base.url")
                );
    }

}
