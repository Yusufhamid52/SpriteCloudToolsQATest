# SpriteCloudToolsQATest

## Overview

This is a maven project created using **Selenium Framework with Java**.

The project follows **Page object model** mechanism with **Page Factory**. **Javadoc** is added for each class. **Extent Report** is used for creating reports with logs and screenshot (only in case of failure). **TestNG framework** is used for executing the tests.

**TestCases** folder contains SpriteCloud UI tests.docx which has 3 UI test cases with description, steps and expected result.

## Project Hierarchy

* **src/main/java** : consists of 2 packages - 

  * **base** package. It contains 3 java classes. BaseTestSetup, Constants and WebDriverSetUp. There is a javadoc comment in each class explaining the contents. 	

  * **toolsQAPages** package. It consists of 3 java classes. DemoQAHomePage, ToolsQAHomePage and TutorialsPage. There is a javadoc comment in each class explaining     the contents.
  
* **src/test/java** : consists of 3 packages - 

  * **spriteCloudUITests** package. It consists of 2 test classes. TestDemoQAUI and TestToolsQAUI. There is a javadoc comment in each class explaining the test      cases.
  *  **Utils** package. It consist of chromedriver.exe compatible with chrome version 96.0.4664.45. 
  *  **testng_xmls** package. It consists of TestNG suite for running all the tests.


## Test reports 
   There are 2 types of reports available in this project. 
   1. **Extent reports :** /test-extent
      These are custom reports I created which consists of test method name and pass and fail status. Also, I have added logs to describe each test step while the         test runs.
      They also have very nice pictorial represenatation of test runs in the form of colorful graphs. 
      
   2. **Maven reports :** /target/surefire-reports/emailable-report.html
      These reports are generated as part of maven test run and provides good details of each test execution. 
      
## Calliope
Please find this link for my test results uploaded to calliope https://app.calliope.pro/reports/108614/public/d0681ce1-608c-4355-a936-f5532f5d7cbb

## How to run tests locally
### Pre-requisite :
    1.  Required an IDE (Eclipse or intelliJ)
    2.  Java (JDK and JRE) installed in the PC and JAVA_HOME set in environment variable (windows) or bash profile (mac).
    3.  Maven installed and M2_HOME set in environment variable (windows) or bash profile (mac).
    4.  Git installed 
    
### Steps to download the project in IDE: 
   1. Open command prompt and go to the path where the project is to be downloaded
   2. Run `git clone <url>`. Get the url from the project path https://github.com/Yusufhamid52/SpriteCloudToolsQATest. 
   3. Open IDE and go to File > Open and choose the git cloned project.

### Steps to run the project using TestNG:
   1. Verify if the project is visible in project panel.
   2. Add TestNG to the IDE. If the project is in eclipse, go to Help > Eclipse Marketplace > enter TestNG in search. 
   3. Go to src/test/java/testNG_xmls/testng.xml. 
   4. Right click and run as TestNG suite.
   5. After test run the reports are generated in folder *test-extent*

### Steps to run the project using Maven:
   1. Right click on the project, Run as > maven clean
   2. After step 1 is successful, right click on the project, Run as > maven test
   3. After test run the reports are generated in target > surefire-reports > emailable-report.html. Also, the reports are generated in folder *test-extent*. 

## How to run tests using CI/CD
### Pre-requisite :
    1. Download and install Jenkins war file from https://www.jenkins.io/
    2. Open command prompt and go to the path where jenkins is installed on the machine
    3. Run the command `java -jar jenkins.war`. This starts jenkins server locally on the machine.
    4. Go to browser and open `localhost:8080`. This will open the jenkins start page where it will ask for admin password. In windows open        "C:/Users/<username>/.jenkins/secret". Paste the key from this file to admin password tab. Click next.
    5. On next page, set a new user for jenkins or just continue as admin.
    6. Jenkins is started. Create a new maven job to run the project from github and check the build for results. 

## Selected scenarios, approach and importance
    * The scenarios selected in the TestCases doc are to test the overall functionality of DemoQA and ToolsQA website.
    * The first scenario verifies the banner is present and the "Join Now" button is clickable. This is important from the business point of view as more users           register the more the company generates revenue. So this test is required to check it works as expected.
    * The second test is to verify all the content in the Tutorials menu of the Tools QA website https://www.toolsqa.com/ is present. This is important from               customer point of view as the contents should be as expected.
    * The third test is to check if the search button is working and provides accurate results. This is important becuase it helps customer to easily search the           tutorial of interest required. 

## Next steps to the project 
    * Add more tests to increase the coverage.
    * Open a bug to improve the UI alignment of the registration form
    * Open a bug to improve the accuracy of search results (the current UI test for this functionality in the project fails)
