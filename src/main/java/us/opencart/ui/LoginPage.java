package us.opencart.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.util.List;

public class LoginPage extends HomePage {

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


}
