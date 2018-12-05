## Brief Description

This API it's a just a samplhe use for spring boot + swagger + spring fox.

## Configure environment
1-) Setup

1.1-) Installing Java 8
Download JDK on http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

Set JAVA_HOME env based on where the JDK will be installed. Add to PATH as JAVA_HOME\bin. 

To know if the java is installed, run "java -version" command on prompt should work 

1.2-) Installing Maven
Download the latest version on https://maven.apache.org/download.cgi?Preferred=ftp%3A%2F%2Fmirror.reverse.net%2Fpub%2Fapache%2F

Define the variable MVN_HOME on your OS pointing to the extracted directory. Add to the PATH variable the MVN_HOME\bin.

To know if the mvn is installed, run the command "mvn --version" and check if its recognition by the SO or not;

# Run application on command line

1-) Configure config.json based on the environment that will be tested.

2-) Running application:

mvn spring-boot:run -Dspring.profiles.active="local"

2.1-) How to know when it's up ?
The message like above will appear:
" Started **** in 4.596 seconds"

PS1: The default port is defined on src\main\resources\application.properties

## Acessing application by swagger-UI

Access http://localhost:8080/api/v1/spring-sample/swagger-ui.html

