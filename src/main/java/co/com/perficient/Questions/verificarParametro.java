package co.com.perficient.Questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class verificarParametro implements Question<String> {

    private String llave;

    @Override
    public String answeredBy(Actor actor) {
        return lastResponse().body().path(llave);
    }

    public verificarParametro(String parametro){
        this.llave = parametro;
    }

    public static verificarParametro delServicio(String parametro){return new verificarParametro(parametro);}
}
