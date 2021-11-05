#sudo docker build -t backend-for-frontend-reactive-rest-web .
#sudo docker run -it --rm -p 8080:8080 -p 1100:1100 -e CATALINA_OPTS="-Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.rmi.port=1100 -Dcom.sun.management.jmxremote.port=1100 -Dcom.sun.management.jmxremote.ssl=false" backend-for-frontend-rest-web
#application should connect to wiremock by instance ip(192.168.100.4), not localhost
#netstat -a -n -o | find "123456"
FROM openjdk:11.0-jdk-oracle

COPY target/backend-for-frontend-reactive-rest-web-1.0-SNAPSHOT-spring-boot.jar app.jar

EXPOSE 8080
EXPOSE 1100

ENV JAVA_TOOL_OPTIONS "-Dcom.sun.management.jmxremote.ssl=false \
-Dcom.sun.management.jmxremote.authenticate=false \
-Dcom.sun.management.jmxremote.port=1100 \
-Dcom.sun.management.jmxremote.rmi.port=1100 \
-Dcom.sun.management.jmxremote.host=0.0.0.0 \
-Djava.rmi.server.hostname=0.0.0.0"

ENTRYPOINT java -jar -Xmx$JAVA_XMX /app.jar


