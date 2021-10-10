FROM maven:3-jdk-11

WORKDIR /opt/fibonacci-service

COPY . /opt/fibonacci-service
RUN mvn package

ENV PORT 8080
EXPOSE $PORT
CMD [ "sh", "-c", "mvn -Dserver.port=${PORT} spring-boot:run" ]
