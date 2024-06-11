# Versão automatizada
FROM maven:3.8.5-openjdk-17 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17
WORKDIR /app
COPY --from=build ./app/target/*.jar ./app.jar
EXPOSE 8761
ENTRYPOINT java -jar app.jar

# Comandos no terminal
# docker build --tag cursoms-eureka:1.0 .
# docker run --name teste-eureka -p 8761:8761 cursoms-eureka

# Vesão não automatizada ( Mas funciona)
# FROM openjdk:17
# Diretório de trabalho
# WORKDIR /app
# Copia o .jar do target para um novo arquivo com nome app.jar
# COPY ./target/eurekaserver-0.0.1-SNAPSHOT.jar app.jar
# Expor a porta 8761 para fora
# EXPOSE 8761
# Execução
# ENTRYPOINT java -jar app.jar