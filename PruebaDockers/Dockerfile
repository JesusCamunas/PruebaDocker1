#Primero construimos con maven nuestra aplicación
FROM maven:3.5-alpine

RUN mkdir -p /build
WORKDIR /build
COPY pom.xml /build
RUN mvn -B dependency:resolve dependency:resolve-plugins

COPY src /build/src
RUN mvn clean install

#Tras construirla con maven pasamos a ejecutar nuestro war con springboot

FROM openjdk:14-alpine

COPY ./target/PruebaDockers-1.war PruebaDockers-1.war
#Añadimos estas lineas para poder debugear
EXPOSE 7074
ENV DEBUG_INFO="-Xdebug -Xrunjdwp:transport=dt_socket,address=0.0.0.0:7074,server=y,suspend=n"
ENTRYPOINT [ "sh", "-c", "java ${DEBUG_INFO} -Dspring.profiles.active=docker -jar /PruebaDockers-1.war" ]

#CMD ["java", "-Dspring.profiles.active=docker", "-jar", "PruebaDockers-1.war"]
#FROM tomcat:latest
#ADD target/PruebaDockers-1.war /usr/local/tomcat/webapps/PruebaDockers-1.war
#EXPOSE 8080
#CMD ["catalina.sh", "run"]