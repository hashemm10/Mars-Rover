/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hashem.mars.rover.services;

import com.hashem.mars.rover.Points.Coordinates;
import com.hashem.mars.rover.Vehicles.Movement;
import com.hashem.mars.rover.Vehicles.Rover;
import com.hashem.mars.rover.direction.RoverDirection;
import com.hashem.mars.rover.landingplace.Mars;
import com.hashem.mars.rover.obstacles.Obstacle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author #EM
 */
//   Coordinates MarsCoordinates= new Coordinates(20,20);
//Mars mars=new Mars(MarsCoordinates);
//        RoverDirection direction= new RoverDirection("NORTH");
//                Coordinates RoverCoordinates = new Coordinates (0,0,direction,mars);
//Rover rover = new Rover(RoverCoordinates,direction);
public class MarsRoverService {
    public Mars CreateMars(){
        Coordinates MarsMax= new Coordinates(20,20); // DEFAULT MARS  VALUES 
            Coordinates MarsMin= new Coordinates(-20,-20);// DEFAULT MARS VALUES
           List<Obstacle> obstacles = new ArrayList<>(); // List That Contains all Obstacles
            Coordinates ob1Coordinates= new Coordinates(0,5);// obstacle 1 coordintes
            Obstacle ob1 = new Obstacle(ob1Coordinates);
            Coordinates ob2Coordinates= new Coordinates(4,-6);// obstacle 2 coordintes
            Obstacle ob2 = new Obstacle(ob2Coordinates);
                        Coordinates ob3Coordinates= new Coordinates(-11,4);// obstacle 3 coordintes
            Obstacle ob3 = new Obstacle(ob3Coordinates);
              Coordinates ob4Coordinates= new Coordinates(14,4);// obstacle 3 coordintes
            Obstacle ob4 = new Obstacle(ob4Coordinates);
         obstacles.add(ob1);
             obstacles.add(ob2);
             obstacles.add(ob3);
                obstacles.add(ob4);
           
            
    Mars Mars = new Mars (MarsMin,MarsMax,obstacles);
    return Mars;
    }
    public Rover Run(String Direction,int RoverX ,int RoverY) throws Exception{

            
            RoverDirection RD= new RoverDirection (Direction);
        Coordinates RovCoordinates= new Coordinates(RoverX,RoverY,RD,CreateMars());
         Movement Movement = new Movement(RovCoordinates,RD,CreateMars());
        Rover rover= new Rover(RovCoordinates,RD,Movement); // Init Rover 
    
    return rover;
    }
  
}
