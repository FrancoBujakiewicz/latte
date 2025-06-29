
 FROM openjdk:24-jre-slim

 COPY /build/libs/latte-0.0.1-SNAPSHOT.jar latte.jar

 EXPOSE 8080

 ENTRYPOINT ["java", "-jar", "latte.jar"]

