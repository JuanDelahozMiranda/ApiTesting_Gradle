package co.com.perficient.Questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class verificarMensaje implements Question<String> {

    private String llave;

    @Override
    public String answeredBy(Actor actor) {
        return Integer.toString(lastResponse().body().path(llave));
    }

    public verificarMensaje(String parametro){
        this.llave = parametro;
    }

    public static verificarMensaje delServicio(String parametro){return new verificarMensaje(parametro);}
}