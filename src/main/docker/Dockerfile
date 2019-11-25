FROM java:8-jdk-alpine

COPY ./target/spring-boot-mp-1.0.0.jar /usr/app/

WORKDIR /usr/app/

RUN sh -c 'touch spring-boot-mp-1.0.0.jar'

ENTRYPOINT ["java", "-jar", "spring-boot-mp-1.0.0.jar"]