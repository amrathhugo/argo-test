FROM amazoncorretto:21

WORKDIR /app

COPY build/libs/orderService-1.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]