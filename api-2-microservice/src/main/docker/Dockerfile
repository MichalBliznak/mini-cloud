FROM openjdk:8-jdk-alpine
RUN apk update && apk upgrade && apk add netcat-openbsd bash
RUN mkdir -p /usr/local/api2service
ADD @project.build.finalName@.jar /usr/local/api2service/
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh
