package us.opencart.ui;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import us.opencart.exceptions.MissingConfigurationPropertyException;


public class HomePage extends PageObject {

    public static final String COMPARISON_OPTION = "Compare this Product";
    public static final String WISH_LIST_OPTION = "Add to Wish List";
    public static final String ADD_TO_CART_OPTION = "Add to Cart";
    public static final String REMOVE_OPTION = "Remove";

    public static final String COMPARISON_SUCCESS_MESSAGE = "Success: You have added %s to your product comparison!";
    public static final String WISH_LIST_SUCCESS_MESSAGE = "Success: You have added %s to your wish list!";
    public static final String ADD_TO_CART_SUCCESS_MESSAGE_FORMAT = "Success: You have added %s to your shopping cart!";

    public static final Target ITEM_CONTAINS_TEXT = Target.the("Item contains text: {0}").locatedBy("//*[contains(text(),'{0}')]");
    public static final Target RIGHT_MENU_ITEM_CONTAINS_TEXT = Target.the("Right item and contains text: {0}").locatedBy("//aside[@id='column-right']//*[contains(text(),'{0}')]");
    public static final Target TOP_NAV_ITEM_CONTAINS_TEXT = Target.the("Top Nav bar item html: {0} and contains text: {1}").locatedBy("//nav[@id='top']//{0}[contains(text(),'{1}')]");
    public static final Target My_ACC_TOP_NAV_BAR = TOP_NAV_ITEM_CONTAINS_TEXT.of("span", "My Account");
    public static final Target LOGIN_OPT_NAV_BAR = TOP_NAV_ITEM_CONTAINS_TEXT.of("a", "Login");
    public static final Target LOGOUT_OPT_NAV_BAR = TOP_NAV_ITEM_CONTAINS_TEXT.of("a", "Logout");
    public static final Target REGISTER_NAV_BAR = TOP_NAV_ITEM_CONTAINS_TEXT.of("a", "Register");
    public static final Target WISH_LIST_NAV_BAR = TOP_NAV_ITEM_CONTAINS_TEXT.of("span", "Wish List");
    public static final Target ADD_TO_CART_NAV_BAR = TOP_NAV_ITEM_CONTAINS_TEXT.of("span", "Shopping Cart");
    public static final Target CATEGORY_ALONE_TARGET = Target.the("Target of item with Category: {0}").locatedBy("//nav[@id='menu']//*[text()='{0}']");
    public static final Target CATEGORY_SUBCATEGORY_TARGET = Target.the("Target of item with Category: {0} and Subcategory {1}").locatedBy("//nav[@id='menu']//*[text()='Desktops']/ancestor::li//a[contains(text(),'{1}')]");
    public static final Target ITEM_BOX_TARGET = Target.the("Target of item box with Name: {0}").locatedBy("//*[text()='{0}']/ancestor::div[@class='product-thumb']");
    public static final Target ITEM_BUTTON = Target.the("Target of '{1}' button item box with Name: {0}").locatedBy("//*[text()='{0}']/ancestor::div[@class='product-thumb']//button[@data-original-title='{1}']");
    public static final Target ADD_TO_CART_BUTTON = Target.the("Target of '{1}' button item box with Name: {0}").locatedBy("//*[text()='{0}']/ancestor::div[@class='product-thumb']//span[text()='{1}']");
    public static final Target ALERT_MESSAGE_TARGET = Target.the("Target of alert message").locatedBy("//div[@class='alert alert-success alert-dismissible']");


    public static String getBaseUrl() {
        EnvironmentVariables env = SystemEnvironmentVariables.createEnvironmentVariables();
        return EnvironmentSpecificConfiguration.from(env)
                .getOptionalProperty("webdriver.base.url").orElseThrow(
                        () -> new MissingConfigurationPropertyException("webdriver.base.url")
                );
    }

}
