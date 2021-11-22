#sudo docker build -t backend-for-frontend-node-rest-web .
#sudo docker run -it --rm -p 8080:8080 -p 1100:1100 -e CATALINA_OPTS="-Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.rmi.port=1100 -Dcom.sun.management.jmxremote.port=1100 -Dcom.sun.management.jmxremote.ssl=false" backend-for-frontend-rest-web
#application should connect to wiremock by instance ip(192.168.100.4), not localhost
#netstat -a -n -o | find "123456"
FROM node:12


WORKDIR /usr/src/app
COPY package*.json ./
RUN npm install

COPY ./build/ .

EXPOSE 8080

ENTRYPOINT ["node", "app.js"]


