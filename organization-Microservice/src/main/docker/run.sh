#!/bin/sh

echo "********************************************************"
echo "Starting organization Server";
echo "********************************************************"
java -Dserver.port=$SERVER_PORT  -Dspring.profiles.active=$PROFILE -Dspring.zipkin.base-url=$ZIPKIN_URI -Dspring.cloud.kubernetes.secrets.paths=$SECRET_PATH -jar /usr/local/organizationMicroService/organization-Microservice-0.0.1-SNAPSHOT.jar
