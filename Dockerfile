# Build
FROM openjdk:17-slim AS build

WORKDIR /app

COPY --chown=gradle:gradle . .

RUN ./gradlew clean build -x test


# Run Stage
FROM bellsoft/liberica-openjdk-alpine:17

WORKDIR /app

COPY --from=build /app/build/libs/*SNAPSHOT.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
