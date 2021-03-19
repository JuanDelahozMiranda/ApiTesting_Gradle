package co.com.perficient.Tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static co.com.perficient.Enums.serviceUrl.URL;

public class ejecutarGet implements Task {

    private String orden;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(URL.toString()+orden)
        );
    }

    public ejecutarGet(String parametro){
        this.orden = parametro;
    }

    public static ejecutarGet conParametro(String parametro){
        return Tasks.instrumented(ejecutarGet.class, parametro);
    }
}
