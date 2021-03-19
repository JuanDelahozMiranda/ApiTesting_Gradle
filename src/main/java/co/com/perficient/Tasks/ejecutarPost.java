package co.com.perficient.Tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import java.util.List;

import static co.com.perficient.Enums.serviceUrl.*;

public class ejecutarPost implements Task {

    private String parametros;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(URL.toString()).with(request ->
                request.header("Content-Type","application/json")
                        .body(parametros)
        ));
    }

    public ejecutarPost(List<String> body){
        this.parametros = body.get(1);
    }

    public static ejecutarPost conParametro(List<String> body){
        return Tasks.instrumented(ejecutarPost.class, body);
    }
}
