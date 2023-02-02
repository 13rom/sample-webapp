FROM maven:3.8.6-eclipse-temurin-17-alpine as BUILD

ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"

WORKDIR /opt/demo

COPY pom.xml .

RUN mvn dependency:go-offline

COPY ./src ./src

RUN mvn clean install -Dmaven.test.skip=true -B


FROM eclipse-temurin:17.0.5_8-jre-alpine

WORKDIR /opt/demo

ARG JAR_FILE=*.jar

COPY --from=BUILD /opt/demo/target/${JAR_FILE} ./app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
