# CalculateNextBirthdayAPI
This repo will calculate next birthday based on birthdate and unit given in terms of hour, day, week and month
Birthday calculaor endpoints calculates time left for next birthday based on given birthdate and unit in which user wants to know time left
Please attach Excel sheet for manual test cases
About Automation framework
Tech stack:
1.	Rest Assured 
2.	Cucumber 
3.	Java

Steps to run this code
1.	Make sure you have git installed on machin
2.	Clone this project using "git clone https://github.com/monilj/CalculateNextBirthdayAPI.git"
3.	Launch any code editor. IntelliJ idea is preferrable 
4.	Open this project
5.	Click on Build project
6.	Go to TestRunner.java
7.	Right click and Run
8.	Once execution is done, check target folder in repositor
9.	Right click and open cucumber-report.html to examine the execution report

Future Scope
1.	Current code is not run time code as expcted vaues will get change tomorrow and tests will going to be fail
2.	Need to write Java util methods which compare current time and current date and validate the response
3.	CI/CD integration: Need to integrate this repo with Jenkins and schedule nightliy job.s
