# My Mars Rover
## Description
My Mars Rover is an API that translates the commands sent from user to instructions that are understood by my Rover.
I used JUnit library in order to make it easier to test all functions.
My Project follows the OOP architecture where we can discover all the source code in `main` folder and all tested functions in `test` folder.

### run project
Needs: `Java 11` & `maven`


### Program 
1. Extract files from `MyMarsRover.zip`
2. Open target file.
3. Run batch file RunProject.bat 


### Executing program


* When the API starts it takes the Rover's initial coordinates on mars as an input while informing the user with Mars's lower left coordinates and top right coordinates.
* Then the API requests the initial direction of the rover and rover only accepts 4 diffrent directions which are (NORTH,EAST,SOUTH,WEST).
* Now The Rover has landed on Mars and ready to accept commands from user.
* The Rover requests from the user to enter any command whether a single command or a string of commands.
* The Rover stars to move as per the instructions provided by the user.
* User should input "Y" if he wants to enter another command and any other key if he wants to exit.
* If the rover reached any obstacle while executing commands it will immediately stop and inform the user with its current position, direction and "STOPPED" message.
* The program will ask the user whether he would like the rover to generate a command or whether the user would like to continue or to enter commands manually.
*If User Pressed G it will automatically generate 11 command string to take the rover to a safe place and avoid all obstacles. 
* Calculated Command will be printed for the user.
* The API once again will ask the user whether to enter another command, Generate a command or  to exit. (Y To continue G to Generate Command) (user can press any other key to exit program)
* If the user enters the calculated command the rover will execute each and every command until it reaches the safe place that the rover already calculated before.
* The user once again will be asked if there's any other command that the user want the rover to execute or to exit the program.
* If the command entered by the user reaches any obstacle it will once again stop and inform the user with its current position, direction and "STOPPED" message
* It will automatically generate a calculated command to take the rover to a safe place.
