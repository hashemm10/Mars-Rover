/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hashem.mars.rover.landingplace;

import com.hashem.mars.rover.Points.Coordinates;
import com.hashem.mars.rover.obstacles.Obstacle;
import java.util.List;

/**
 *
 * @author #EM
 */
public class Mars {
private  List <Obstacle> obstacles;
    Coordinates Cmax;
    Coordinates Cmin;

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }
    public Coordinates getCmax() {
        return Cmax;
    }

    public void setCmax(Coordinates Cmax) {
        this.Cmax = Cmax;
    }

    public Coordinates getCmin() {
        return Cmin;
    }

    public void setCmin(Coordinates Cmin) {
        this.Cmin = Cmin;
    }

    public Mars(Coordinates pmin , Coordinates pmax, List<Obstacle> ob){
    this.Cmin=pmin;
    this.Cmax=pmax;
    this.obstacles=ob;
    
    }

}
