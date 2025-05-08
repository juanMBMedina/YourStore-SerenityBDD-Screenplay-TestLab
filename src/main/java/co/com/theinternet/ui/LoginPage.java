package co.com.theinternet.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static final String URL = "https://the-internet.herokuapp.com/login";
    public static final Target USERNAME_FIELD = Target.the("username field").located(By.id("username"));
    public static final Target PASSWORD_FIELD = Target.the("password field").located(By.id("password"));
    public static final Target LOGIN_BUTTON = Target.the("login button").located(By.cssSelector("button[type='submit']"));
    public static final Target SECURE_AREA = Target.the("secure area").located(By.cssSelector("div#flash"));
}
