#sudo docker build -t backend-for-frontend-rest-web .
#sudo docker run -it --rm -p 8080:8080 -p 1100:1100 -e CATALINA_OPTS="-Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.rmi.port=1100 -Dcom.sun.management.jmxremote.port=1100 -Dcom.sun.management.jmxremote.ssl=false" backend-for-frontend-rest-web
#application should connect to wiremock by instance ip(192.168.100.4), not localhost
#netstat -a -n -o | find "123456"
FROM tomcat:9.0.54-jre11-openjdk

RUN rm -rf /usr/local/tomcat/webapps/ROOT

EXPOSE 8080
EXPOSE 1100

RUN echo  "#! /bin/sh" >> /usr/local/tomcat/bin/setenv.sh
RUN echo 'export CATALINA_OPTS="$CATALINA_OPTS -Djava.awt.headless=true -Xmx$JAVA_XMX -server -Djava.rmi.server.hostname=127.0.0.1 -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.rmi.port=1100 -Dcom.sun.management.jmxremote.port=1100 -Dcom.sun.management.jmxremote.ssl=false"'  >> /usr/local/tomcat/bin/setenv.sh

ADD target/backend-for-frontend-rest-web-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war