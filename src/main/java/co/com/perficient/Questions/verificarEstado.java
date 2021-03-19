package co.com.perficient.Questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class verificarEstado implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Integer.toString(lastResponse().statusCode());
    }

    public static verificarEstado delServicio(){return new verificarEstado();}
}
