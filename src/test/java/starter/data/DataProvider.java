package starter.data;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.data.EnviromentImplementation;
import starter.data.exceptions.NotValidEnvironmentException;

import java.util.HashMap;

public class DataProvider {


    JsonObject userData;
    @Steps(shared = true)
    private EnviromentImplementation enviroment;

    @Step("Verificar si el usuario tiene datos de prueba")
    public void setUserData(String customerType) throws NotValidEnvironmentException {
        enviroment.initEnviroment();
        String data = null;
        HashMap<String, String> userHashMap = new HashMap<>();
        userHashMap.put("Sauce customer", enviroment.customerSwagLabs());
        data = userHashMap.get(customerType);
        userData = JsonParser.parseString(data).getAsJsonObject();
    }

    public JsonObject getUserData() { return this.userData; }

}
