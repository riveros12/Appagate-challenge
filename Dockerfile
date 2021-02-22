FROM adoptopenjdk/openjdk11:latest
ADD target/Appagate-challenge-0.0.1-SNAPSHOT.jar Appagate-challenge-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar","Appagate-challenge-0.0.1-SNAPSHOT.jar"]