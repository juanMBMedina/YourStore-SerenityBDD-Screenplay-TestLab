package us.opencart.ui;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import us.opencart.exceptions.MissingConfigurationPropertyException;


public class HomePage extends PageObject {

    public static final Target ITEM_CONTAINS_TEXT = Target.the("Item contains text: {0}").locatedBy("//*[contains(text(),'{0}')]");
    public static final Target RIGHT_MENU_ITEM_CONTAINS_TEXT = Target.the("Right item and contains text: {0}").locatedBy("//aside[@id='column-right']//*[contains(text(),'{0}')]");
    public static final Target TOP_NAV_ITEM_CONTAINS_TEXT = Target.the("Top Nav bar item html: {0} and contains text: {1}").locatedBy("//nav[@id='top']//{0}[contains(text(),'{1}')]");
    public static final Target My_ACC_TOP_NAV_BAR = TOP_NAV_ITEM_CONTAINS_TEXT.of("span","My Account");
    public static final Target LOGIN_OPT_NAV_BAR = TOP_NAV_ITEM_CONTAINS_TEXT.of("a","Login");
    public static final Target LOGOUT_OPT_NAV_BAR = TOP_NAV_ITEM_CONTAINS_TEXT.of("a","Logout");

    public static String getBaseUrl() {
        EnvironmentVariables env = SystemEnvironmentVariables.createEnvironmentVariables();
        return EnvironmentSpecificConfiguration.from(env)
                .getOptionalProperty("webdriver.base.url").orElseThrow(
                        () -> new MissingConfigurationPropertyException("webdriver.base.url")
                );
    }

}
