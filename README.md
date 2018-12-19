## Brief Description

This API it's a just a sample use for spring boot + spring actuator + swagger with java 11 version.

## Configure environment
1-) Setup

1.1-) Installing Java 11
Download JDK on http://www.oracle.com/technetwork/java/javase/downloads

Set JAVA_HOME env based on where the JDK will be installed. Add to PATH as JAVA_HOME\bin. 

To know if the java is installed, run "java -version" command on prompt should work 

1.2-) Installing Maven
Download the latest version on https://maven.apache.org/download.cgi

Define the variable MVN_HOME on your OS pointing to the extracted directory. Add to the PATH variable the MVN_HOME\bin.

To know if the mvn is installed, run the command "mvn --version" and check if its recognition by the SO or not;

# Run application on command line

1-) Configure config.json based on the environment that will be tested.

2-) Running application by command line:

mvn spring-boot:run

## Acessing application by swagger-UI

Access http://localhost:8080/gateway/swagger-ui.html

