package co.com.perficient.Enums;

public enum mensajesError {

    MSJ_ERROR_CODIGO_RESPUESTA("El codigo eseprado: \"%s\", no corresponde con el obtenido: \"%s\""),
    MSJ_ERROR_PARAMETEO_BODY("El parametro eseprado: \"%s\", no corresponde con el obtenido: \"%s\"");

    private String msj;

    mensajesError(String msj){ this.msj = msj; }

    public String getMsj(){ return msj;}
}
