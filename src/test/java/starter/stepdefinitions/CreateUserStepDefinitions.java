package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import org.apache.http.HttpStatus;
import starter.models.Employee;
import starter.questions.api.VerifyUserCreation;
import starter.tasks.rest.CreateUser;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static starter.utils.Constants.*;

public class CreateUserStepDefinitions {

    private EnvironmentVariables environmentVariables;

    @Given("{actor} hired {} with the {} role")
    public void userStartsWork(Actor actor, String employeeName,String jobPosition) {
        actor.whoCan(
                CallAnApi.at(environmentVariables.getProperty(BASE_URL))
        );
        actor.remember(JOB_POSITION, jobPosition);
        actor.remember(EMPLOYEE_NAME, employeeName);
    }

    @When("{actor} creates his information in the company")
    public void heCreatesHisInformationInTheCompany(Actor actor) {
        //Employee employee = Employee.withThis().name("").job("").build();
        //Employee employee = new Employee();
        //employee.setJob("a");
        //employee.getJob();

        actor.attemptsTo(
                CreateUser.inTheApp(Employee.with()
                        .job(actor.recall(JOB_POSITION))
                        .name(actor.recall(EMPLOYEE_NAME)).build())
        );
    }


    @Then("{actor} should be able to see {}'s id")
    public void shouldBeAbleToSeeCarlosSId(Actor actor, String expectedName) {
        actor.should(
                seeThat( "response code",
                        VerifyUserCreation.ResponseCodeOfService(), equalTo(HttpStatus.SC_CREATED)
                ),
                seeThat( "user name created",
                        VerifyUserCreation.NameEmployeeCreated(), equalTo(expectedName)
                )
        );
    }
}
