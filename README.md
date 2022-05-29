# Mars-Rover

About the Project
------------------------
1. Resources folder has the input file. input should be given as below.
2. First line is upper right plateau coordinates - each coordinnates should be separate by a space
3. Seconnd line rover position
4. Third linew is the instruction for rover
5. 3 and 4 can be followed in succession.
   
Steps to run the project
------------------------
1. mvn clean install
1. mvn exec:java -Dexec.mainClass="MarsRover" - just to execute main class without test
2. mvn test - just to execute the test
3. mvn test exec:java -Dexec.mainClass="MarsRover" - this will run tests first and then runs the main class
   
