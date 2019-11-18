#!/bin/sh

echo "********************************************************"
echo "Starting Authentication Service                           "
echo "********************************************************"
java -Dserver.port=$SERVER_PORT -Dspring.profiles.active=$PROFILE -jar /usr/local/authenticationservice/auth-server-0.0.1-SNAPSHOT.jar