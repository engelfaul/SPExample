package starter.data;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${environment}.properties"})
public interface Enviroment extends Config {

    String customerSwagLabs();
}
