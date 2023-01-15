#FROM openjdk:11.0.7-jre-slim
##RUN addgroup -S spring && adduser -S spring -G spring
##USER spring:spring
#ARG DEPENDENCY=target/dependency
#COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY ${DEPENDENCY}/META-INF /app/META-INF
#COPY ${DEPENDENCY}/BOOT-INF/classes /app
#ENTRYPOINT ["java","-cp","app:app/lib/*","com.exam.ExamserverApplication"]

# Maven build container
FROM openjdk:11.0.7-jre-slim
ADD target/examserver-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

