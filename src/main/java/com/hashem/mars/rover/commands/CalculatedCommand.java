/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hashem.mars.rover.commands;

import com.hashem.mars.rover.Points.Coordinates;
import com.hashem.mars.rover.Vehicles.Movement;
import com.hashem.mars.rover.direction.RoverDirection;
import com.hashem.mars.rover.landingplace.Mars;
import com.hashem.mars.rover.obstacles.Obstacle;
import java.util.List;

/**
 *
 * @author #EM
 */
public class CalculatedCommand {
    private StringBuilder Command = new StringBuilder();


    private Coordinates coordinates;
    private RoverDirection roverDirection;
    private String Direction;


    private Movement movement;
    private Mars mars;

    public Mars getMars() {
        return mars;
    }

    public void setMars(Mars mars) {
        this.mars = mars;
    }

        int XPrediction=0;
        int YPrediction=0;
    public CalculatedCommand(Coordinates coordinates, RoverDirection roverDirection,Movement move) {
        this.coordinates = coordinates;

   this.movement=move;
this.Direction=roverDirection.getDirection();
         XPrediction=coordinates.getX();
         YPrediction=coordinates.getY();
         mars=this.coordinates.getMars();
    }
    

    public StringBuilder getCommand() {
        return this.Command;
    }

    public void setCommand(StringBuilder cc) {
        this.Command = cc;
    }
    
    public String getDirection() {
        return Direction;
    }

    public void setDirection(String Direction) {
        this.Direction = Direction;
    }

    public int getXPrediction() {
        return XPrediction;
    }

    public void setXPrediction(int XPrediction) {
        this.XPrediction = XPrediction;
    }

    public int getYPrediction() {
        return YPrediction;
    }

    public void setYPrediction(int YPrediction) {
        this.YPrediction = YPrediction;
    }
public String TryMoveAfterStop(){
int len=0;
while(Command.length()<11){ //11 is the the number of Characters Of The Calculated Command
        String LastThreeCommands = Command.substring(Command.length() - len);
   
    if(LastThreeCommands.equals("FBF") || LastThreeCommands.equals("BFB")){
        MoveRightAfterFailedPrediction(Direction);
        Command.append("R");
    }
    else if(PredictForward()){}
else{
PredictBackward();
}
    len++;
}
return Command.toString();
}
//       coordinates.setY(coordinates.getY()-1);
//movement.WrapMars(coordinates.getX(),coordinates.getY());
public boolean PredictForward(){
    boolean PredictOk=false;
    switch(Direction){
case "NORTH" :
      if(!movement.CheckObstacles(XPrediction,YPrediction+1)){
    YPrediction=YPrediction+1;
    PredictionWrapMars(XPrediction,YPrediction);
    PredictOk=true;
     Command.append("F");
      }
      else {
 
      PredictOk=false;
      }
        break;

        case "SOUTH" :
      if(!movement.CheckObstacles(XPrediction,YPrediction-1)){
    YPrediction=YPrediction-1;
     PredictionWrapMars(XPrediction,YPrediction);
       PredictOk=true;
        Command.append("F");
      }
        else {
     
      PredictOk=false;
      }
        break;  
        case "WEST" :
      if(!movement.CheckObstacles(XPrediction-1,YPrediction)){

    XPrediction=XPrediction-1;
     PredictionWrapMars(XPrediction,YPrediction);
       PredictOk=true;
        Command.append("F");
      }
        else {

      PredictOk=false;
      }
        break;
        
         case "EAST" :
      if(!movement.CheckObstacles(XPrediction+1,YPrediction)){

    XPrediction=XPrediction+1;
         PredictionWrapMars(XPrediction,YPrediction);

       PredictOk=true;
        Command.append("F");
      }
        else {

          
      PredictOk=false;
      }
      
        break;
    
    }

return PredictOk;}

public boolean PredictBackward(){
    boolean PredictOk=false;
    switch(Direction){
case "NORTH" :
      if(!movement.CheckObstacles(XPrediction,YPrediction-1)){

    YPrediction=YPrediction-1;
     PredictionWrapMars(XPrediction,YPrediction);
       PredictOk=true;
        Command.append("B");
      }
        else {

          
      PredictOk=false;
      }
        break;
        
        
        case "SOUTH" :
                  if(!movement.CheckObstacles(XPrediction,YPrediction+1)){

    YPrediction=YPrediction+1;
     PredictionWrapMars(XPrediction,YPrediction);
    PredictOk=true;
        Command.append("B");
      }
      else {

      PredictOk=false;
      }

        break;
        
        case "WEST" :
      if(!movement.CheckObstacles(XPrediction+1,YPrediction)){

    XPrediction=XPrediction+1;
     PredictionWrapMars(XPrediction,YPrediction);
       PredictOk=true;
           Command.append("B");
      }
        else {

      PredictOk=false;
      }
        break;
        
         case "EAST" :
               if(!movement.CheckObstacles(XPrediction-1,YPrediction)){
    XPrediction=XPrediction-1;
     PredictionWrapMars(XPrediction,YPrediction);
       PredictOk=true;
           Command.append("B");
      }
        else {
      PredictOk=false;
      }
    
      
        break;
    
    }
return PredictOk;}
public void MoveRightAfterFailedPrediction (String orientation) {
     switch(orientation){
         case "NORTH" :
           Direction="EAST";
             break;
              case "SOUTH" :
               Direction="WEST";
             break;
              case "EAST" :
               Direction="SOUTH";
             break;
              case "WEST" :
               Direction="NORTH";
             break;
     }
}
public void PredictionWrapMars( int x , int y ){
if(x<=mars.getCmin().getX())
    
{
   XPrediction=(getMars().getCmax().getX());
}
if(x>getMars().getCmax().getX())  
{
XPrediction=(getMars().getCmin().getX()+1);
}
if(y<=mars.getCmin().getY())
    
{
   YPrediction=getMars().getCmax().getY();
}
if(y>getMars().getCmax().getY())  
{
YPrediction=((getMars().getCmin().getY())+1);
}
}}



