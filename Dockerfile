FROM maven:3-jdk-11
ADD . /ePortfolio-2077
WORKDIR /ePortfolio-2077
ARG DATABASE_URL_ARG
ARG DATABASE_USERNAME_ARG
ARG DATABASE_PASSWORD_ARG
ENV DATABASE_API_URL=$DATABASE_URL_ARG DATABASE_API_USERNAME=$DATABASE_USERNAME_ARG DATABASE_API_PASSWORD=$DATABASE_PASSWORD_ARG
RUN mvn clean install
FROM openjdk:11-jdk
VOLUME /tmp
COPY --from=0 "/ePortfolio-2077/server/target/*.jar" app.jar
CMD [ "sh", "-c", "java -Dserver.port=$PORT -Dspring.datasource.url=$DATABASE_API_URL -Dspring.datasource.username=$DATABASE_API_USERNAME -Dspring.datasource.password=$DATABASE_API_PASSWORD -Xmx300m -Xss512k -XX:CICompilerCount=2 -Dfile.encoding=UTF-8 -XX:+UseContainerSupport -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]