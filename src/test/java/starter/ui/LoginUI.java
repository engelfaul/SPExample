package starter.ui;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginUI {
    public static final By USER_NAME = By.id("user-name");
    public static final By USER_PASSWORD = By.id("password");
    public static final Target LOGIN_BUTTON = Target.the("login-button").located(By.id("login-button"));

}
