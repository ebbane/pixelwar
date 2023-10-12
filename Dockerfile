#
# Build stage
#
FROM maven:3.8.3-openjdk-17-slim AS build
COPY . /app/pixelwar/
RUN mvn -f /app/pixelwar/ clean package

#
# Package stage
#
FROM openjdk:latest
RUN  echo --from=build /app/pixelwar/target/pixelwar.jar
COPY --from=build /app/pixelwar/target/pixelwar.jar /usr/local/lib/pixelwar.jar
EXPOSE 8080
ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000","-jar","/usr/local/lib/pixelwar.jar"]