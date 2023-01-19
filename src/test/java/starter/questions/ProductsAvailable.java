package starter.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import starter.ui.SwagLabsStoreUI;

public class ProductsAvailable implements Question {

    public static Question<String> value(){
        return new ProductsAvailable();
    }
    @Override
    public Object answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).find(SwagLabsStoreUI.PRODUCTS_TITTLE).getText();
    }
}
