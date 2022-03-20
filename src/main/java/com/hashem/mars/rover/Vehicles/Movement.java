/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hashem.mars.rover.Vehicles;

import com.hashem.mars.rover.Points.Coordinates;
import com.hashem.mars.rover.direction.RoverDirection;
import com.hashem.mars.rover.landingplace.Mars;
import com.hashem.mars.rover.obstacles.Obstacle;


/**
 *
 * @author #EM
 */
public class Movement {
    RoverDirection roverDirection;
    Coordinates coordinates ;


    Mars mars;
    char LastFailedMovement=' ';
 String DirectionBeforePredictions="";
    StringBuilder SB = new StringBuilder();
    public Movement( Coordinates C , RoverDirection RD , Mars M){
    
    this.coordinates= C;
    this.roverDirection=RD;
    this.mars=M;
    }
        public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
 
public boolean GoForward(){
    
    boolean stop= false ;
switch(roverDirection.getDirection()){
case "NORTH" :
   if(!CheckObstacles(coordinates.getX(),coordinates.getY()+1)){
       coordinates.setY(coordinates.getY()+1);
    WrapMars(coordinates.getX(),coordinates.getY());
SB.append("F");
        break;}
   else{
        FoundObstacleMessage(coordinates.getX(),(coordinates.getY()+1));
        LastFailedMovement='F';
           
         
       stop=true;
       break;
   }
 
case "SOUTH":
     if(!CheckObstacles( coordinates.getX(),coordinates.getY()-1)){
       coordinates.setY(coordinates.getY()-1);
        WrapMars(coordinates.getX(),coordinates.getY());
SB.append("F");
        break;}
   else{
       FoundObstacleMessage(coordinates.getX(),(coordinates.getY()-1));
         LastFailedMovement='F';
         
         
       stop=true;
       break;
   }
        
case "EAST":
     if(!CheckObstacles( (coordinates.getX()+1),coordinates.getY())){
       coordinates.setX(coordinates.getX()+1);
    WrapMars(coordinates.getX(),coordinates.getY());
SB.append("F");
        break;}
   else{
        FoundObstacleMessage((coordinates.getX()+1),(coordinates.getY()));
          LastFailedMovement='F';
          
         
       stop=true;
       break;
   }   
case "WEST":
     if(!CheckObstacles( (coordinates.getX()-1),coordinates.getY())){
       coordinates.setX(coordinates.getX()-1);
   WrapMars(coordinates.getX(),coordinates.getY());
   SB.append("F");
         
        break;}
   else{
         FoundObstacleMessage((coordinates.getX()-1),(coordinates.getY()));
         LastFailedMovement='F';

         
       stop=true;
       break;
   }}
return stop;
}





public boolean GoBackward(){
     boolean stop= false ;
switch(roverDirection.getDirection()){
case "NORTH" :
      if(!CheckObstacles( coordinates.getX(),coordinates.getY()-1)){
       coordinates.setY(coordinates.getY()-1);
WrapMars(coordinates.getX(),coordinates.getY());
SB.append('B');
        break;}
   else{
       FoundObstacleMessage(coordinates.getX(),(coordinates.getY()-1));
         LastFailedMovement='B';
         
        
       stop=true;
       break;
   }
    
case "SOUTH":
        if(!CheckObstacles( coordinates.getX(),coordinates.getY()+1)){
       coordinates.setY(coordinates.getY()+1);
WrapMars(coordinates.getX(),coordinates.getY());
SB.append('B');
                break;
        }

        else{
         FoundObstacleMessage(coordinates.getX(),(coordinates.getY()+1));
         LastFailedMovement='B';
            
        
       stop=true;
       break;
   }
        
case "EAST":
  if(!CheckObstacles( (coordinates.getX()-1),coordinates.getY())){
       coordinates.setX(coordinates.getX()-1);
WrapMars(coordinates.getX(),coordinates.getY());
   SB.append('B');
        
break;
  
  }
   else{
         FoundObstacleMessage((coordinates.getX()-1),(coordinates.getY()));
LastFailedMovement='B';
       stop=true;
       break;
   }
         
case "WEST":
      if(!CheckObstacles( (coordinates.getX()+1),coordinates.getY())){
       coordinates.setX(coordinates.getX()+1);
       WrapMars(coordinates.getX(),coordinates.getY());
      SB.append('B');
        break;}
   else{
         FoundObstacleMessage((coordinates.getX()+1),(coordinates.getY()));
 LastFailedMovement='B';
    
        
       stop=true;
       break;
      }
     
}
 return stop;
}


 public void TurnRight (String orientation) {
     switch(orientation){
         case "NORTH" :
             roverDirection.setDirection("EAST");
             break;
              case "SOUTH" :
             roverDirection.setDirection("WEST");
             break;
              case "EAST" :
             roverDirection.setDirection("SOUTH");
             break;
              case "WEST" :
             roverDirection.setDirection("NORTH");
             break;
     }
    }

 public void TurnLeft (String orientation) {
     switch(orientation){
         case "NORTH" :
             roverDirection.setDirection("WEST");
                   break;
              case "SOUTH" :
             roverDirection.setDirection("EAST");
                   break;
              case "EAST" :

             roverDirection.setDirection("NORTH");
                   break;
              case "WEST" :
      
             roverDirection.setDirection("SOUTH");
             break;
     }
    }
 
 
 
 public boolean  CheckObstacles(int checkX,int checkY ){
boolean ObstacleFound= false;
    for (int i =0; i < mars.getObstacles().size(); i++) {
      
           Obstacle CheckForObstacle = mars.getObstacles().get(i);
        if ( checkX == CheckForObstacle.getCoordinates().getX() && checkY== CheckForObstacle.getCoordinates().getY()){

    ObstacleFound=true;
            }  
}
    return  ObstacleFound;
}

public void FoundObstacleMessage(int x , int y){
    System.out.println("Can't Move Forward Towards "+
        roverDirection.getDirection()+" "+"Because There's An Obstacle At "+"("+x+","+y+")");
            }


public void WrapMars( int x , int y ){
if(x<mars.getCmin().getX())
    
{
    coordinates.setX(mars.getCmax().getX());
}
if(x>mars.getCmax().getX())  
{
coordinates.setX(mars.getCmin().getX()+1);
}
if(y<mars.getCmin().getY())
    
{
    coordinates.setY(mars.getCmax().getY());
}
if(y>mars.getCmax().getY())  
{
 coordinates.setY((mars.getCmin().getY())+1);
}
}

}


