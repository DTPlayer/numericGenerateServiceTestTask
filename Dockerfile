# Этап 1: Сборка проекта
FROM gradle:jdk21-alpine AS builder

WORKDIR /app

COPY . .

RUN gradle clean build

FROM bellsoft/liberica-openjre-debian:23.0.2 AS runner

RUN useradd -ms /bin/bash spring-user
USER spring-user

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]