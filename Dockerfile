#FROM ubuntu:latest
#LABEL authors="sathish"
FROM eclipse-temurin:21-jre
ADD target/demo-deploy-for-ecommerce.jar demodeploy.jar
ENTRYPOINT ["java", "-jar", "/demo-deploy-for-ecommerce.jar"]
EXPOSE 8080
#ENTRYPOINT ["top", "-b"]
