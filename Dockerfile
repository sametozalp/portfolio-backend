FROM amazoncorretto:21-alpine
WORKDIR /app

COPY /target/*.jar app.jar

EXPOSE 8080

ENV SPRING_PROFILES_ACTIVE=prod

ENTRYPOINT ["java", "-jar", "app.jar"]

# docker build -t sametozalp/portfolio-backend .