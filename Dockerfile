FROM adoptopenjdk/openjdk16:x86_64-alpine-jre16u-2021-08-21-00-55-beta-nightly
RUN mkdir /opt/app
COPY /target/Demo.jar /opt/app
EXPOSE 8080
CMD ["java", "-jar", "/opt/app/Demo.jar"]