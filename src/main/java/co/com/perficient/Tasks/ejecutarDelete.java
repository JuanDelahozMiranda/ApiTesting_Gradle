package co.com.perficient.Tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static co.com.perficient.Enums.serviceUrl.URL;

public class ejecutarDelete implements Task {

    private String parametro;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(URL.toString() + parametro));
    }

    public ejecutarDelete(String llave) {
        this.parametro = llave;
    }

    public static ejecutarDelete conParametro(String llave) {
        return Tasks.instrumented(ejecutarDelete.class, llave);
    }
}
