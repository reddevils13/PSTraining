FROM tomcat:9-slim
WORKDIR /usr/local/tomcat/webapps/
ARG WAR_FILE=target/*.war
ADD ${WAR_FILE} /usr/local/tomcat/webapps/
EXPOSE 8080