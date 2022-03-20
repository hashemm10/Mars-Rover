/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hashem.mars.rover.Points;

import com.hashem.mars.rover.commands.CalculatedCommand;
import com.hashem.mars.rover.direction.RoverDirection;
import com.hashem.mars.rover.landingplace.Mars;
import com.hashem.mars.rover.obstacles.Obstacle;

/**
 *
 * @author #EM
 */
public class Coordinates {
        private int x;
    private int y;
    private Mars mars;
    private RoverDirection roverDirection;
public Coordinates(int x , int y, RoverDirection roverDirection, Mars m){
this.x=x;
this.y =y;
this.roverDirection= roverDirection;
this.mars=m;
}
public Coordinates(int x , int y){
this.x=x;
this.y =y;
}
    public Mars getMars() {
        return this.mars;
    }

    public void setMars(Mars mars) {
        this.mars = mars;
    }
    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }


}