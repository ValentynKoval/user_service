FROM eclipse-temurin:21-jdk
EXPOSE 8080
ENV JAR_FILE=target/user_service-*-SNAPSHOT.jar
COPY ${JAR_FILE} /user_service.jar
ENTRYPOINT ["java", "-jar", "/user_service.jar"]