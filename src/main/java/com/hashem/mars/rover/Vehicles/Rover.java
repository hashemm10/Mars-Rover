/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hashem.mars.rover.Vehicles;

import com.hashem.mars.rover.Points.Coordinates;
import com.hashem.mars.rover.commands.CalculatedCommand;
import com.hashem.mars.rover.direction.RoverDirection;

/**
 *
 * @author #EM
 */
public class Rover {
    private Coordinates A;

    public Coordinates getA() {
        return A;
    }

    public void setA(Coordinates A) {
        this.A = A;
    }

    public RoverDirection getDirection() {
        return Direction;
    }

    public void setDirection(RoverDirection Direction) {
        this.Direction = Direction;
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }
    private RoverDirection Direction ;
    private Movement movement;
    StringBuilder sc  = new StringBuilder();
private boolean Stopped=false;
 
    public Rover (){}
    public Rover (Coordinates coordinates, RoverDirection direction, Movement M) throws Exception{
       boolean x =CheckDirectionIfValid(direction);
        this.A = coordinates;
        this.movement=M;
        if(x){
        this.Direction =direction;}
        else {
            throw new Exception ("InValid Direction ");}
        }



    @Override
    public String toString() {
        return "("  + A.getX() +", "+A.getY()+")"+" "+Direction.getDirection();
    }

    //F
    public void CheckCommandString(String command) throws Exception {
        for (char c : command.toCharArray()) {
            if (!CommandExecution(c)) {
                break;
            }
        
        }
     CurrentCoordinatesAndDirection( Stopped);

    }
public boolean CommandExecution(char c) throws Exception {
    boolean  command = false ;
   switch(Character.toUpperCase(c)){
     case 'F':
         
                Stopped = movement.GoForward();
                if(Stopped){
                  
                    command=false;
                    StoppedMessege();
   
                    break;
                }
                 command = true;
                      break;
     case 'B':
             
                   Stopped =movement.GoBackward();
                if(Stopped){
                  
                    command=false;
                    StoppedMessege();

                    break;
                }
                 command = true;
                      break;
     case 'L':
                movement.TurnLeft(Direction.getDirection());
                command = true;
               
          break;
             
       case 'R':
                movement.TurnRight(Direction.getDirection());
               command = true;
               
               break;
      
                
              default:
                 throw  new Exception("INVALID COMMAND");
   }

   return  command;}


private  boolean CheckDirectionIfValid(RoverDirection direction) {
    boolean valid;
    if (direction.GetDirectionsList().contains(direction.getDirection())){
    valid= true;
  }
    else{
     valid = false;
   }
  return valid ;


}
    public  void CurrentCoordinatesAndDirection(boolean stop){
        if(!stop){
        System.out.println(toString());}
    }
    public void StoppedMessege(){
        System.out.println(toString() + " STOPPED");
//        CalculatedCommand  cs= new CalculatedCommand(A,Direction,movement);
//       String Command=cs.TryMoveAfterStop();
//        System.out.println(Command);
   
    }
    public String CalculateCommand(){
    
            CalculatedCommand  cs= new CalculatedCommand(A,Direction,movement);
       String Command=cs.TryMoveAfterStop();
        System.out.println(Command);
        return Command;
    }

}
