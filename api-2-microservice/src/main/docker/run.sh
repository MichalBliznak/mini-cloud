#!/bin/sh

echo "********************************************************"
echo "Waiting for the discovery server to start on port $DISCOVERY_PORT"
echo "********************************************************"
while ! `nc -z discovery  $DISCOVERY_PORT`; do sleep 3; done
echo "******* Eureka Server has started"

echo "********************************************************"
echo "Starting API 2 Server"
echo "********************************************************"
java -jar /usr/local/api2service/@project.build.finalName@.jar
