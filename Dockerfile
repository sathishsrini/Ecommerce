FROM eclipse-temurin:21 AS build

WORKDIR /app
COPY . /app/.

# Correct the cache key prefix
RUN --mount=type=cache,id=maven_cache,target=/root/.m2/repository \
    mvn clean package
