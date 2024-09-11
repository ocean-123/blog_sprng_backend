FROM openjdk:19
LABEL mantainer="ocean"

ADD target/checkJwtAuth-0.0.1-SNAPSHOT.jar checkJwtAuth.jar
#WORKDIR /app
#
#COPY target/*.jar /app/
ENTRYPOINT ["java", "-jar", "checkJwtAuth.jar"]
