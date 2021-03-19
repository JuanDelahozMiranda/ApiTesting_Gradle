#language: es
  Característica: Realizar ejecucion de un servicio y verificar la respuesta
    Yo como usuario
    Necesito consumir un servicio de consulta, creacion y eliminacion
    Para verificar las funcionalidades de un modulo de administracion

  @Service2
  Esquema del escenario: : El cliente solicita crear un store utilizando una api
    Dado que el usuario utiliza el servicio "ConsultaCliente"
    Y ejecuta el servico
      |body|
      |<Body>|
    Entonces se debe obtener un codigo correcto "<codigo>"
    Entonces Valido el mensaje obtenido del "id" sea igual a "<id_esperado>"
    Entonces Valido el mensaje obtenido del "petId" sea igual a "<id_esperado>"
    Entonces Valido el mensaje obtenido del "quantity" sea igual a "<cantidad>"
    Entonces Valido el parametro obtenido del "status" sea igual a "<status>"

    Ejemplos:
    |Body                                                                                                   |codigo|id_esperado|cantidad|status|
    |{"id": 77, "petId": 77, "quantity": 4, "shipDate": "2021-03-15", "status": "placed", "complete": false}|200   |77         |4       |placed|

  @Service2
  Esquema del escenario: : validar consulta de orden en el store
    Dado que el usuario utiliza el servicio "ConsultaCliente"
    Cuando se realiza el servicio Get "<orden>"
    Entonces se debe obtener un codigo correcto "<codigo>"

    Ejemplos:
    |orden |codigo|
    |/77   |200   |
    |/99   |404   |

  @Service2
  Esquema del escenario: : validar borrado de orden en el store
    Dado que el usuario utiliza el servicio "ConsultaCliente"
    Cuando se realiza el servicio Delete "<orden>"
    Entonces se debe obtener un codigo correcto "<codigo>"
    Entonces Valido el mensaje obtenido del "code" sea igual a "<codigo>"
    Entonces Valido el parametro obtenido del "type" sea igual a "<type>"
    Entonces Valido el parametro obtenido del "message" sea igual a "<mensaje>"

    Ejemplos:
    |orden |codigo|type   |mensaje        |
    |/77   |200   |unknown|77             |
    |/99   |404   |unknown|Order Not Found|