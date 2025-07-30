# 빌드
FROM openjdk:17-slim AS build

WORKDIR /app

COPY . .

RUN ./gradlew clean build -x test


# Run Stage
FROM bellsoft/liberica-openjdk-alpine:17

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]