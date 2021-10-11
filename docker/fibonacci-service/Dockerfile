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

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

