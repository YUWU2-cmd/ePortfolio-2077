FROM maven:3-jdk-11
ADD . /ePortfolio-2077
WORKDIR /ePortfolio-2077
RUN mvn clean install
FROM openjdk:11-jdk
VOLUME /tmp
COPY --from=0 "/ePortfolio-2077/target/*.jar" app.jar
CMD [ "sh", "-c", "java -Dserver.port=$PORT -Xmx300m -Xss512k -XX:CICompilerCount=2 -Dfile.encoding=UTF-8 -XX:+UseContainerSupport -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
