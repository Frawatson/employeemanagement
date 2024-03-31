FROM openjdk

EXPOSE 8090

ENV APP_HOME /usr/scr/app

COPY target/UserManagement-0.0.1-SNAPSHOT-jar $APP_HOME/app.jar

CMD ["java", "jar", "app.jar"]