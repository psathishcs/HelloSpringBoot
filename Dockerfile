FROM java:8
VOLUME /tmp
ADD build/libs/hellospringboot-1.0.1.jar app.jar
EXPOSE 8080
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Duser.timezone=GMT", "-jar","/app.jar"]