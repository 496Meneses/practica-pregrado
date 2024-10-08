FROM maven:3.6.0-jdk-8-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:8
VOLUME /tmp
COPY --from=build /home/app/target/unicauca-0.0.1.jar unicauca.jar
ENV TZ="America/Bogota"
EXPOSE $PORT
ENTRYPOINT ["java","-jar","/unicauca.jar"]
