package starter.questions.api;

import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static starter.utils.RestUtils.convertJsonMap;

public class VerifyUserCreation {

    private static String NAME_TAG = "name";
    public static Question<Integer> ResponseCodeOfService(){
      return actor -> lastResponse().statusCode();
    };

    public static Question<String> NameEmployeeCreated(){
      return actor -> convertJsonMap(lastResponse().getBody().prettyPrint()).get(NAME_TAG).toString();
    };


}
