package starter.tasks.rest;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import starter.models.Employee;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.apache.http.HttpHeaders.CONTENT_TYPE;
import static org.apache.http.entity.ContentType.APPLICATION_JSON;
import static starter.utils.Constants.CREATE_USER_ENDPOINT;
import static starter.utils.Constants.EMPLOYEE_SESSION;

public class CreateUser implements Task {

    private Employee employee;

    public CreateUser(Employee employee) {
        this.employee = employee;
    }

    public static CreateUser inTheApp(Employee employee){
        return instrumented(CreateUser.class, employee);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(CREATE_USER_ENDPOINT)
                        .with(
                                request -> request
                                        .header(CONTENT_TYPE, ContentType.JSON)
                                        .body(employee)
                        )
        );

        actor.remember(EMPLOYEE_SESSION, employee);

    }
}
