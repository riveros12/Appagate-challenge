FROM adoptopenjdk/openjdk11:latest
ADD target/Appagate-challenge-0.0.1-SNAPSHOT.jar Appagate-challenge-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","docker-spring-boot.jar"]