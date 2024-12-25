FROM amazoncorretto:21

WORKDIR /app

COPY build/libs/customerService-1.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]