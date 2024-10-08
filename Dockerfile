
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/veterinaria-0.0.1-SNAPSHOT.jar /app/veterinaria.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/veterinaria.jar"]

