/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;
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
/**
 *
 * @author #EM
 */
public class PredictionCommandTest {
    private CalculatedCommand PredictedCommand;
        private StringBuilder Command = new StringBuilder();

    private RoverDirection roverDirection;

    private Coordinates coordinates;
        private Coordinates point;
            private Coordinates point2;
            private Rover roverRobot;

    private String Direction;
    private Movement movement;
    private Mars mars;
private List<Obstacle> obstacles;

 @Before
    public void before() throws Exception {

          obstacles=new  ArrayList<>();
            Coordinates ob2Coordinates= new Coordinates(4,3);// obstacle 2 coordintes
            Obstacle ob2 = new Obstacle(ob2Coordinates);
             obstacles.add(ob2);
     point=new Coordinates(-5,-5);
     point2 =new Coordinates(5,5);
     mars= new Mars(point,point2,obstacles);
     coordinates= new Coordinates(4,0);

     roverDirection=new RoverDirection("NORTH");

      coordinates= new Coordinates(coordinates.getX(),coordinates.getY(),roverDirection,mars);
        movement=new Movement(coordinates,roverDirection,mars);
       roverRobot=new Rover(coordinates,roverDirection,movement);
          
PredictedCommand= new CalculatedCommand(coordinates,roverDirection,movement);


    // Mars=new Mars()
        //  this.roverRobot = new Rover(x, y, orientation);
    }
    
       @Test
    public void AbilityToGenerate11Commands() throws Exception {
        assertThat(PredictedCommand.TryMoveAfterStop().length()).isEqualTo(11);
    }
  @Test
    public void AbilityToGenerate11CommandsWhenObstacleIsFound() throws Exception {
        int expected = obstacles.get(0).getCoordinates().getX() - 1;
             int expected2 = obstacles.get(0).getCoordinates().getY()- 1;
        roverRobot.CheckCommandString("FRFRFRFRBLBLR");
       String GeneratedCommand = roverRobot.CalculateCommand();
        roverRobot.CheckCommandString(GeneratedCommand);
       assertThat(roverRobot.getA().getX()).isNotEqualTo(expected);
         assertThat(roverRobot.getA().getY()).isNotEqualTo(expected2);
    }    
    
    
        @Test
    public void RightMoveAfterPredictionFailed() throws Exception {
    PredictedCommand.MoveRightAfterFailedPrediction(PredictedCommand.getDirection());
         assertThat(PredictedCommand.getDirection()).isEqualTo("EAST");
    }
      @Test
    public void CorrectPredictionForwardMove() throws Exception {
        int expected=PredictedCommand.getYPrediction()+1;
    PredictedCommand.PredictForward();
         assertThat(PredictedCommand.getYPrediction()).isEqualTo(expected);
    }
           @Test
    public void WrongPredictionForwardMove() throws Exception {
             obstacles.add(new Obstacle(new Coordinates(4,1)));
        int expected=PredictedCommand.getYPrediction();
    PredictedCommand.PredictForward();
         assertThat(PredictedCommand.getYPrediction()).isEqualTo(expected);
    }
    @Test
    public void CorrectPredictionBackwardMove() throws Exception {
        int expected=PredictedCommand.getYPrediction()-1;
    PredictedCommand.PredictBackward();
         assertThat(PredictedCommand.getYPrediction()).isEqualTo(expected);
    }
     @Test
    public void WrongPredictionBackwardMove() throws Exception {
             obstacles.add(new Obstacle(new Coordinates(4,-1)));
        int expected=PredictedCommand.getYPrediction();
    PredictedCommand.PredictBackward();
         assertThat(PredictedCommand.getYPrediction()).isEqualTo(expected);
    }
  @Test
  public void TestPredictionWrapMars(){
  int expected = mars.getCmax().getY();
  for(int i=0;i<mars.getCmax().getY();i++){
      PredictedCommand.PredictBackward();
  }
    assertThat(PredictedCommand.getYPrediction()).isEqualTo(expected);
}}


