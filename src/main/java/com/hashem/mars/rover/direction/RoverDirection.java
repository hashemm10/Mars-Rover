/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hashem.mars.rover.direction;

import java.util.*;

/**
 *
 * @author #EM
 */
public class RoverDirection {
  private static final List<String> ValidDirections = Arrays.asList("NORTH", "SOUTH", "WEST", "EAST");
        private String direction;
    public RoverDirection(String direction){
    this.direction=direction;
    }


    public String getDirection() {
        return direction;
    }
  public List GetDirectionsList() {
        return ValidDirections;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
}
