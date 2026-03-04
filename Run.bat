@echo off
:: Navigate to your project folder where the pom.xml is
cd /d "C:\Cs_Automation\Cs_Automation"

:: Use the full path to your maven bin folder
call "C:\Cs_Automation\apache-maven-3.9.12\bin\mvn" clean test

pause