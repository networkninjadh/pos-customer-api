FROM adoptopenjdk/openjdk11:alpine-jre
CMD mnv clean package
COPY target/pos-customer-api-0.0.1-SNAPSHOT.jar pos-customer-api.jar
ENTRYPOINT ["java", "-jar", "pos-customer-api.jar"]
EXPOSE 8082