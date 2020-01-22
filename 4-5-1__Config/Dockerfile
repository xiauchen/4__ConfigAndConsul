FROM openjdk:8-alpine
RUN mkdir demoA
COPY target/4-5-1__Config-v1.1.jar /demoA
WORKDIR /demoA
ENTRYPOINT ["java","-jar","4-5-1__Config-v1.1.jar"]