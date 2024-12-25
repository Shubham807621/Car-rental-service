FROM openjdk:21-jdk

COPY target/CarRentalService.jar .

EXPOSE 8080

ENTRYPOINT ["java","-jar", "CarRentalService.jar"]