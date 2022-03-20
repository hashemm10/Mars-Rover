/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hashem.mars.rover;


import com.hashem.mars.rover.Vehicles.Rover;

import com.hashem.mars.rover.landingplace.Mars;
import com.hashem.mars.rover.services.MarsRoverService;

import static java.lang.System.exit;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author #EM
 */
public class MarsRoverMain  {
    
    public static void main(String[] args) throws Exception{
        
        MarsRoverService marsRoverService=new MarsRoverService();
        Mars mars= marsRoverService.CreateMars();
        boolean exit = false;
        int RoverX=0;
        int RoverY=0;
         Scanner myObj = new Scanner(System.in); 
System.out.println("Enter The Initial Coordinates Of Mars Rover at Any Point On Mars Coordinates Lower Left "
        +"("+mars.getCmin().getX()+","+mars.getCmin().getY()+")" +
        " And Top Right Coordinates "+"("+mars.getCmax().getX()+","+mars.getCmax().getY()+")");
try {
 RoverX= myObj.nextInt();
 RoverY= myObj.nextInt();
} catch (InputMismatchException e) {
  e.printStackTrace();
  System.err.println("Entered value is not an integer");
  exit(1);
}    
     System.out.println("Enter The Initial Direction Of Mars Rover");
     myObj.nextLine(); // Skip the remainder of the double line
String Direction = myObj.nextLine();
          Rover rover= marsRoverService.Run(Direction, RoverX, RoverY);
          while (!exit){
 System.out.println("Enter Full Command In Order For Rover Mars To Operate");
    String Command =   myObj.nextLine();
 rover.CheckCommandString(Command);
System.out.println("Would You Like To add Another Command ? Or Rover Can Generate A Command For You");
System.out.println("Press Y To Continue Or G To Generate By Rover");
String AnsweString=myObj.nextLine();
if(AnsweString.equals("G")){
    rover.CalculateCommand();
}
else if (!AnsweString.equals("Y") && !AnsweString.equals("G") )
    exit(0);
    }
    }}

