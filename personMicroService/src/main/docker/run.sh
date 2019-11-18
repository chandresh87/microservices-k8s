#!/bin/sh

getPort() {
    echo $1 | cut -d : -f 3 | xargs basename
}

echo "********************************************************"
echo "Starting Person Server"
echo "********************************************************"
java -Dserver.port=$SERVER_PORT  -Dspring.profiles.active=$PROFILE -Dspring.zipkin.base-url=$ZIPKIN_URI -Dspring.cloud.kubernetes.secrets.paths=$SECRET_PATH -jar /usr/local/personMicroService/personMicroService-0.0.1-SNAPSHOT.jar
