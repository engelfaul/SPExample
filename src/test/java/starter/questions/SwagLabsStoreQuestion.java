package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Enabled;
import net.serenitybdd.screenplay.questions.Text;
import starter.ui.SwagLabsStoreUI;

public class SwagLabsStoreQuestion {

    public static Question<Boolean> ProductsIsPresent(){
        return actor -> Enabled.of(SwagLabsStoreUI.PRODUCTS_TITTLE).answeredBy(actor);
    }
    public static Question<String> ProductsAvailable(){
        return actor -> Text.of(SwagLabsStoreUI.PRODUCTS_TITTLE).answeredBy(actor);
    }

}
