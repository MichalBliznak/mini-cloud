#!/bin/bash

echo "********************************************************"
echo "Waiting for services to start on ports $WAIT_FOR_PORTS"
echo "********************************************************"
IFS=',' read -ra services <<< "${WAIT_FOR_SERVICES}"
for srv in "${services[@]}"; do
    echo "Waiting for service ${srv}..."
    url=`echo ${srv} | cut -f1 -d:`
    port=`echo ${srv} | cut -f2 -d:`
    while ! `nc -z $url $port`; do sleep 3; done
done
echo "******* Services have started"

echo "********************************************************"
echo "Starting API 1 Server"
echo "********************************************************"
java -jar /usr/local/api1service/@project.build.finalName@.jar
