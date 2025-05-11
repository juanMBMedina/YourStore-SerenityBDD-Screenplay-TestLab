package us.opencart.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.util.function.Function;

public class RegisterPage extends HomePage {

    public static final String SUCCESS_REGISTER_MESSAGE = "Congratulations! Your new account has been successfully created!";
    public static final String USER_EXIST_MESSAGE = "Warning: E-Mail Address is already registered!";

    public static final Target INPUT_TEXT_FIRST_NAME = Target.the("First Name input text of Register form").located(By.id("input-firstname"));
    public static final Target INPUT_TEXT_LAST_NAME = Target.the("Last Name input text of Register form").located(By.id("input-lastname"));
    public static final Target INPUT_TEXT_EMAIL = Target.the("Email input text of Register form").located(By.id("input-email"));
    public static final Target INPUT_TEXT_TELEPHONE = Target.the("Telephone input text of Register form").located(By.id("input-telephone"));
    public static final Target INPUT_TEXT_PASSWORD = Target.the("Password input text of Register form").located(By.id("input-password"));
    public static final Target INPUT_TEXT_PASSWORD_CONFIRM = Target.the("Password Confirm input text of Register form").located(By.id("input-confirm"));
    public static final Target RADIO_BUTTON_SUBSCRIBE = Target.the("Radio Button Subscribe of Register form").locatedBy("//label[contains(normalize-space(.), '{0}')]/input[@type='radio']");
    public static final Target CHECK_BOX_PRIVACY = Target.the("Privacy Check Box of Register form with value: {0}").locatedBy("//input[@type='checkbox']");
    public static final Target SUBMIT_BUTTON = Target.the("Submit button in Register form").locatedBy("//input[@type='submit']");

    public static Function<Boolean, String> getText = status -> status ? "Yes" : "No";
    public static Function<Boolean, Target> getSubscribeTarget = status -> RADIO_BUTTON_SUBSCRIBE.of(getText.apply(status));


}
