#--------------------------------------------------------------------------------------------------------------
#--------------------------------------------------------------------------------------------------------------
#
# OpenJDK is an open-source implementation of the Java Platform, Standard Edition. This Dockerfile uses the
# openjdk ersion 18 alpine linux official distribution.
#
# For useful context regarding openjdk, alpine linux and this base image see these links:
# https://openjdk.java.net/
# https://alpinelinux.org/about/
# https://hub.docker.com/_/openjdk
#
#--------------------------------------------------------------------------------------------------------------
#--------------------------------------------------------------------------------------------------------------
FROM openjdk:18-jdk-alpine

#--------------------------------------------------------------------------------------------------------------
# Globally scoped arguements
#--------------------------------------------------------------------------------------------------------------
ARG JAR_FILE=target/*.jar

#--------------------------------------------------------------------------------------------------------------
# Copy jar file to docker image root directory
#--------------------------------------------------------------------------------------------------------------
COPY ${JAR_FILE} fibonacci-service.jar

#--------------------------------------------------------------------------------------------------------------
# Add an entrypoint, this allows us to configure a container that will run as an executable.
# In this case we execute the 'java' command on the container and pass the path to the fibonacci-service.jar
# as the '-jar' command line arguement
#--------------------------------------------------------------------------------------------------------------
ENTRYPOINT ["java","-jar","/fibonacci-service.jar"]

