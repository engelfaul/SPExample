package starter.stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Steps;
import starter.data.exceptions.NotValidEnvironmentException;
import starter.navigation.NavigateTo;
import starter.data.DataProvider;
import starter.questions.ProductsAvailable;
import starter.questions.SwagLabsStoreQuestion;
import starter.tasks.doLogin;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;

public class LoginStepDefinitions {

    @Steps(shared = true)
    protected DataProvider dataProvider;
    @Given("{actor} is a {}")
    public void userNavigatesHomePage(Actor actor, String customerType) throws NotValidEnvironmentException {
        actor.wasAbleTo(NavigateTo.theSauceHomePage());
        dataProvider.setUserData(customerType);

    }

    @When("{actor} tries to login")
    public void userPerfomLogin(Actor actor){
        actor.attemptsTo(
                doLogin.withCredentials(
                        dataProvider.getUserData().get("userName").getAsString(),
                        dataProvider.getUserData().get("password").getAsString())
        );
    }

    @Then("{actor} should see to products list")
    public void userShouldSeeProducts(Actor actor){
        actor.should(seeThat(
                "the displayed title", SwagLabsStoreQuestion.ProductsAvailable(), equalTo("PRODUCTS")
        ));
        theActorInTheSpotlight().should(
                seeThat(
                        "the title is present", SwagLabsStoreQuestion.ProductsIsPresent(), equalTo(true)
                ),
                seeThat(
                        "the displayed title", ProductsAvailable.value(), equalTo("PRODUCTS")
                )
        );

    }
}
