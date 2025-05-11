package us.opencart.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.util.List;

public class LoginPage extends HomePage {

    public static final String LOGOUT_MESSAGE = "You have been logged off your account. It is now safe to leave the computer.";
    public static final String LOGIN_WRONG_MESSAGE = " Warning: No match for E-Mail Address and/or Password.";
    public static final List<String> EXPECTED_HEADERS = List.of(
            "My Account",
            "My Orders",
            "My Affiliate Account",
            "Newsletter"
    );

    public static final Target INPUT_TEXT_EMAIL = Target.the("Email input text of Login form").located(By.id("input-email"));
    public static final Target INPUT_TEXT_PASSWORD = Target.the("Password input text of Login form").located(By.id("input-password"));
    public static final Target SUBMIT_BUTTON = Target.the("Submit button in login form").located(By.xpath("//input[@value='Login']"));
    public static final Target LOGIN_SUCCESS_TITLES = Target.the("Login success title: {0}").locatedBy("//*[@id='content']//h2");
    public static final Target LOGOUT_OPT_RIGHT_MENU = RIGHT_MENU_ITEM_CONTAINS_TEXT.of("Logout");

}
