FROM openjdk:11
EXPOSE 8085
ADD target/covid-tracker-service.jar covid-tracker-service.jar
ENTRYPOINT ["java","-jar","/covid-tracker-service.jar"]