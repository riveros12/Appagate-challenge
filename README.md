# Appagate-challenge
Challenge Software Developer: Reto para Software Developer Appagate
# Comandos

1) Comando para construir & empaquetar

3) Comando para dockerizar

5) Comando probar

7) Comando para ejecutar contenedor

9) CURL para probar la API
  APIKEY(Session) (GET)
  curl -v localhost:8080/appagate/newappid
  Agregar Operando (POST)
  curl -d '{"keyidentifier”:”0338278096946750”,”value”:2.0}’ -H 'Content-Type: application/json' localhost:8080/appagate/add/value
  Obtener Resultado
  Operator: tiene disponible-> SUM,SUBTRACTION,MULTIPLICATION,DIVISION,POW
  curl -v '{"keyidentifier”:”0338278096946750”,”operator”:"sum"}’ -H 'Content-Type: application/json' localhost:8080/appagate/result
11) Diagrama de Arquitectura

13) Diagrama de estrategia CI/DI

14) Comandos pruebas Unitarias

# Ejemplo de Ejecución

a. Se obtiene la sesión inicial <número unico> (GET)
localhost:8080/appagate/newappid
b. Se agregan los operandos cuales quiera (POST)
localhost:8080/appagate/add/value
{
    "keyidentifier":"5538813573420744",
    "value":23.0
}
c.Se solicta el calculo que se desee para lo que estan disponibles; SUM,SUBTRACTION,MULTIPLICATION,DIVISION,POW
localhost:8080/appagate/result
{
    "keyidentifier":"5538813573420744",
    "operator":"SUM"
}
# Escalabilidad & Elastibilidad

1) Una opción es utilizar cache para almacenar las operaciones complejas y así evitar la degradación del servcio con el tiempo 
   y ante la alta concurrencia.
   
# Thread-safety

1) Una opción es utilizar multi hilo para la ejecución de procesos simultaneos(No se implemento)
2) Singleton me permite utilizar instancias ya creadas reduciendo el costo creando objetos ante la alta concurrencia



