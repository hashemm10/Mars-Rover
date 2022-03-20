/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

/**
 *
 * @author #EM
 */
import com.hashem.mars.rover.Points.Coordinates;
import com.hashem.mars.rover.Vehicles.Movement;
import com.hashem.mars.rover.Vehicles.Rover;
import com.hashem.mars.rover.commands.CalculatedCommand;
import com.hashem.mars.rover.direction.RoverDirection;
import com.hashem.mars.rover.landingplace.Mars;
import com.hashem.mars.rover.obstacles.Obstacle;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.assertj.core.api.Assertions.*;
@RunWith(JUnit4.class)
public class TestRover {
    



private  Coordinates point;    
private  Coordinates point2; 
   private Coordinates coordinates;
private  Coordinates RooverCoordinates; 
 private RoverDirection direction;
  private    Movement M;
  private Mars Mars;
    private Rover roverRobot;
    private CalculatedCommand PredictedCommand ;
 List<Obstacle> obstacles = new ArrayList<>(); // List That Contains all Obstacles

    @Before
    public void before() throws Exception {

          
            Coordinates ob2Coordinates= new Coordinates(4,3);// obstacle 2 coordintes
            Obstacle ob2 = new Obstacle(ob2Coordinates);


             obstacles.add(ob2);
     point=new Coordinates(-5,-5);
     point2 =new Coordinates(5,5);
     Mars= new Mars(point,point2,obstacles);
     RooverCoordinates= new Coordinates(0,0);

     direction=new RoverDirection("NORTH");
     M=new Movement(RooverCoordinates,direction,Mars);
      coordinates= new Coordinates(RooverCoordinates.getX(),RooverCoordinates.getY(),direction,Mars);
 roverRobot=new Rover(RooverCoordinates,direction,M);
PredictedCommand= new CalculatedCommand(coordinates,direction,M);

    // Mars=new Mars()
        //  this.roverRobot = new Rover(x, y, orientation);
    }
    
        @Test
    public void SetRoverCoordinates() {
    assertThat(roverRobot.getA()).isEqualToComparingFieldByField(RooverCoordinates);}
    
        @Test
    public void DealingWithSingleCommandF() throws Exception {
        int expected =RooverCoordinates.getY() + 1;
        roverRobot.CommandExecution('F');
        assertThat(roverRobot.getA().getY()).isEqualTo(expected);
    }
    @Test
    public void DealingWithSingleCommadnB() throws Exception {
        int expected = RooverCoordinates.getY() - 1;
        roverRobot.CommandExecution('B');
       assertThat(roverRobot.getA().getY()).isEqualTo(expected);
    }
     @Test
    public void DealingWithSingleCommandL() throws Exception {
        roverRobot.CommandExecution('L');
        assertThat(roverRobot.getDirection().getDirection()).isEqualTo("WEST");
    }

    @Test
    public void DealingWithSingleCommandR() throws Exception {
        roverRobot.CommandExecution('R');
         assertThat(roverRobot.getDirection().getDirection()).isEqualTo("EAST");
    }
       @Test
    public void CheckCaseSensitivity() throws Exception {
        roverRobot.CommandExecution('l');
        assertThat(roverRobot.getDirection().getDirection()).isEqualTo("WEST");
    }
     @Test(expected = Exception.class)
    public void DealingWithUnknowCommand() throws Exception {
        roverRobot.CommandExecution('J');
    }
    
     @Test
    public void DealingWithMulitpleCommands() throws Exception {
        int expected =roverRobot.getA().getX() + 1;
        roverRobot.CheckCommandString("RFR");
        assertThat(roverRobot.getA().getX()).isEqualTo(expected);
        assertThat(roverRobot.getDirection().getDirection()).isEqualTo("SOUTH");
    }
    @Test
    public void CheckIfThereIsNoEdgeOfTheworldToFallOff() throws Exception {
        int expected = Mars.getCmin().getX()  + 1;
        roverRobot.CheckCommandString("RFFFFFF");
        assertThat(roverRobot.getA().getX()).isEqualTo(expected);
    }  
    
        @Test
    public void DealingWithObstacles() throws Exception {
        int expected = obstacles.get(0).getCoordinates().getX() - 1;
        roverRobot.CheckCommandString("FFFRFFFFF");
        assertThat(roverRobot.getA().getX()).isEqualTo(expected);
        assertThat(roverRobot.getDirection().getDirection()).isEqualTo("EAST");
    }
      @Test
  public void TestRoverWrapMars(){
  int expected = Mars.getCmax().getY();
  for(int i=0;i<Mars.getCmax().getY();i++){
      M.GoForward();
    
  }
    assertThat(roverRobot.getA().getY()).isEqualTo(expected);
}
       
  
}
