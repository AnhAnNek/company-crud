# define base docker image
FROM openjdk:17
LABEL maintainer="javaguides.net"
EXPOSE 8080
ADD target/company-crud.jar company-crud.jar
ENTRYPOINT ["java", "-jar", "company-crud.jar"]