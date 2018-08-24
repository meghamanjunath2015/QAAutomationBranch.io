# QAAutomation
QA  Automation Challenge Suite 
## Getting Started

These instructions will get you understand the structure and methods used to implement the scenarios for TEAMS page.

### Requirements

1) IDE (Intellij IDEA, Eclipse, NetBeans)
2) Git

### Installing

Installing java

1) Download and install java sdk 8u172
2) Set JAVA_HOME environment variable 

Installing Maven

1) Download maven zip archive and unzip it to any directory
2) Set M2_HOME environment variable
3) Add M2_HOME to Path variable
4) Check it is set correctly - run 'mvn -version' from command line.

## Running the tests

Tests can be run using maven from command line or IDE terminal:
1) All tests, specified in pom.xml file:
 ```
 mvn clean test 
 ```
2) All tests in specific test class
 ```
mvn -Dtest=TestClass test
 ```
3) Single test method from the Test Class
 ```
 mvn -Dtest=TestClass#TestName test
  ```

Also tests can be run with test runner from IDE interface (right click on test or class and click 'Run')

###Java file(s) that should be able to run from any Mac/Linux server.
example: 
gcj -c \qaAutomationChallenge\out\artifacts\qaAutomationChallenge_jar.java


 
