FROM ubuntu

RUN apt-get update
RUN apt-get upgrade -y
RUN apt install -y openjdk-17-jdk
RUN apt install -y maven

RUN mkdir portfolio-with-spring
WORKDIR portfolio-with-spring/

COPY . .
RUN mvn clean install

RUN cd target/

ENTRYPOINT [ "java", "-jar", "portfolio-with-spring-0.0.1-SNAPSHOT.jar" ]