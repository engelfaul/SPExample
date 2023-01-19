package starter.data;

import net.thucydides.core.annotations.Step;
import org.aeonbits.owner.ConfigFactory;
import starter.data.exceptions.NotValidEnvironmentException;


public class EnviromentImplementation implements Enviroment {

    private Enviroment environment;

    @Step("Validar que existen datos de prueba para el ambiente especificado")
    public void initEnviroment() throws NotValidEnvironmentException {
        if(environment == null){
            environment = ConfigFactory.create(Enviroment.class);
        }
        if (environment.toString().equals("{}")) {
            throw new NotValidEnvironmentException(
                    "  Cause: Not a valid environment, or not specified. Please use -Denvironment=env_name to set a valid environment");
        }
    }
    @Override
    public String customerSwagLabs() {
        return environment.customerSwagLabs();
    }
}
