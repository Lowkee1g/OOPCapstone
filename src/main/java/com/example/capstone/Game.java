package com.example.capstone;

import java.util.ArrayList;
import java.util.List;



public class Game {
    public static void main(String[] args) {
        Map map = new Map(10, 10);
        map.addShip(new Frigat(), new int[][]{{0, 5}}, ship.Direction.DOWN);
        map.addShip(new SpeedBoat(), new int[][]{{0, 0}}, ship.Direction.RIGHT);
        map.addShip(new Submarine(),new int[][]{{6, 2}}, ship.Direction.RIGHT);
        map.addShip(new AircraftCarrier(), new int[][]{{9, 9}}, ship.Direction.RIGHT);
        map.addShip(new Destroyer(), new int[][]{{6, 6}}, ship.Direction.RIGHT);

        map.ShowMap();



    }
}
