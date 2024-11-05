# Build Application
FROM public.ecr.aws/docker/library/maven:3.9.9-ibm-semeru-23-jammy As build

WORKDIR /app

COPY . .

RUN mvn package -DskipTests

# Serve Application
FROM public.ecr.aws/docker/library/openjdk:24-slim-bullseye

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "--enable-preview", "-jar", "app.jar"]