from ubuntu:16.04

RUN apt update && apt install -y openjdk-8-jdk maven

ENV JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64/jre

WORKDIR /api

COPY . ./

RUN mvn install && mvn spring-boot:run
