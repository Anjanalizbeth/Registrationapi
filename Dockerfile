FROM openjdk:8
ADD target/Springbootregapi.jar Springbootregapi.jar
EXPOSE 8091
ENTRYPOINT ["java", "-jar", "Springbootregapi.jar"]
