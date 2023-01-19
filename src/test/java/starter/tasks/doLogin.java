package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.EnterValue;
import starter.ui.LoginUI;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class doLogin implements Task {
    private String userName;
    private String userPassword;

    public doLogin(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public static Performable withCredentials(String userName, String userPassword) {
        return instrumented(doLogin.class, userName, userPassword);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue(userName).into(LoginUI.USER_NAME),
            Enter.theValue(userPassword).into(LoginUI.USER_PASSWORD),
            Click.on(LoginUI.LOGIN_BUTTON)
        );

    }
}
