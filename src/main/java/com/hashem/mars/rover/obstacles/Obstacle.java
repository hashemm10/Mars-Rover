/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hashem.mars.rover.obstacles;

import com.hashem.mars.rover.Points.Coordinates;
import java.util.List;

/**
 *
 * @author #EM
 */
public class Obstacle {
public Obstacle (Coordinates c){


this.coordinates=c;
}
   private  Coordinates coordinates; 
    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
