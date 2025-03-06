FROM ubuntu:latest
LABEL authors="sathish"

ENTRYPOINT ["top", "-b"]
FROM eclipse-temurin:21 AS build
WORKDIR /app
COPY . /app/.
RUN --mount=type=cache,id=s/maven_cache,target=/root/.m2/repository \
    mvn clean package
