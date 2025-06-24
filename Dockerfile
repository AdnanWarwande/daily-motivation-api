FROM openjdk:17
EXPOSE 8080
COPY target/springboot-cidi-workflow.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
