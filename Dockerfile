FROM openjdk:8u121-jre-alpine
MAINTAINER contact.ashitverma@gmail.com

WORKDIR /var/SchoolAPI

ADD target/SchoolAPI-1.0-SNAPSHOT.jar /var/SchoolAPI/SchoolAPI.jar
ADD aws-config.yml /var/SchoolAPI/config.yml

EXPOSE 9000 9001

ENTRYPOINT ["java", "-jar", "SchoolAPI.jar", "server", "config.yml"]
