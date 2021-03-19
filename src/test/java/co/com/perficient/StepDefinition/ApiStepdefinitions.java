package co.com.perficient.StepDefinition;

import co.com.perficient.Enums.mensajesError;
import static co.com.perficient.Enums.serviceUrl.*;
import co.com.perficient.Exceptions.ExcepcionGeneral;
import co.com.perficient.Questions.verificarEstado;
import co.com.perficient.Questions.verificarMensaje;
import co.com.perficient.Questions.verificarParametro;
import co.com.perficient.Tasks.ejecutarDelete;
import co.com.perficient.Tasks.ejecutarGet;
import co.com.perficient.Tasks.ejecutarPost;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.equalTo;

public class ApiStepdefinitions {

    @Before
    public void setUpStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que el usuario utiliza el servicio {string}")
    public void queElUsuarioUtilizaElServicio(String string) {
        theActor("Juan").whoCan(CallAnApi.at(BASE_URL.toString()));
    }

    @Dado("ejecuta el servico")
    public void ejecutaElServico(DataTable body) {
        theActorInTheSpotlight().attemptsTo(ejecutarPost.conParametro(body.asList()));
    }

    @Entonces("Valido el parametro obtenido del {string} sea igual a {string}")
    public void validoElParametroObtenidoDelSeaIgualA(String llave, String parametro_comparado){
        theActorInTheSpotlight().should(seeThat(verificarParametro.delServicio(llave), equalTo(parametro_comparado))
                .orComplainWith(ExcepcionGeneral.class, mensajesError.MSJ_ERROR_PARAMETEO_BODY.getMsj()));
    }

    @Entonces("Valido el mensaje obtenido del {string} sea igual a {string}")
    public void validoElMensajeObtenidoDelSeaIgualA(String llave, String parametro_comparado){
        theActorInTheSpotlight().should(seeThat(verificarMensaje.delServicio(llave), equalTo(parametro_comparado))
                .orComplainWith(ExcepcionGeneral.class, mensajesError.MSJ_ERROR_PARAMETEO_BODY.getMsj()));
    }

    @Cuando("se realiza el servicio Get {string}")
    public void seRealizaElServicioGet(String orden) {
        theActorInTheSpotlight().attemptsTo(ejecutarGet.conParametro(orden));
    }

    @Entonces("se debe obtener un codigo correcto {string}")
    public void seDebeObtenerUnCodigoCorrecto(String codigo) {
        theActorInTheSpotlight().should(seeThat(verificarEstado.delServicio(), equalTo(codigo))
        .orComplainWith(ExcepcionGeneral.class, mensajesError.MSJ_ERROR_CODIGO_RESPUESTA.getMsj())
        );
    }

    @Cuando("se realiza el servicio Delete {string}")
    public void seRealizaElServicioDelete(String orden) {
        theActorInTheSpotlight().attemptsTo(ejecutarDelete.conParametro(orden));
    }
}
