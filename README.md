# Appagate-challenge
Challenge Software Developer: Reto para Software Developer Appagate
# Comandos

1) Comando para construir & empaquetar
    * docker build -f Dockerfile -t docker-spring-boot .
3) Comando para dockerizar
    * sudo docker tag docker-spring-boot:latest scrriveros254/appagate:appagate
    * docker push scrriveros254/appagate:appagate
5) Comando probar
    * docker run -p 8080 <IMAGE_ID> 
7) Comando para ejecutar contenedor
   * docker run -i -t  docker-spring-boot -d docker-spring-boot-container
   * docker run -i -t  1f3801711576 -d appagate-container 
9) CURL para probar la API

  * APIKEY(Session) (GET)
  curl -v localhost:8080/appagate/newappid
  
  * Agregar Operando (POST)
  curl -d '{"keyidentifier”:”0338278096946750”,”value”:2.0}’ -H 'Content-Type: application/json' localhost:8080/appagate/add/value
  
  * Obtener Resultado
  Operator: tiene disponible-> SUM,SUBTRACTION,MULTIPLICATION,DIVISION,POW
  curl -v '{"keyidentifier”:”0338278096946750”,”operator”:"sum"}’ -H 'Content-Type: application/json' localhost:8080/appagate/result
  
11) Diagrama de Arquitectura
    * Correo
13) Diagrama de estrategia CI/DI
    * Correo
14) Comandos pruebas Unitarias
    * mvn clean test
    
# Ejemplo de Ejecución

1) Se obtiene la sesión inicial <número unico> (GET)
localhost:8080/appagate/newappid
2) Se agregan los operandos cuales quiera (POST)
localhost:8080/appagate/add/value

{
    "keyidentifier":"5538813573420744",
    "value":23.0
}

3) Se solicta el calculo que se desee para lo que estan disponibles; SUM,SUBTRACTION,MULTIPLICATION,DIVISION,POW
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



