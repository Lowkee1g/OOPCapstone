package com.example.capstone;

public class Enemy {

    public Enemy() {

    }

    public void setShips(Map map) {
        map.addShip(new Frigat(), new int[][]{{0, 5}}, ship.Direction.DOWN);
        map.addShip(new SpeedBoat(), new int[][]{{0, 0}}, ship.Direction.RIGHT);
        map.addShip(new Submarine(),new int[][]{{6, 2}}, ship.Direction.RIGHT);
        map.addShip(new AircraftCarrier(), new int[][]{{9, 9}}, ship.Direction.RIGHT);
        map.addShip(new Destroyer(), new int[][]{{6, 6}}, ship.Direction.RIGHT);
    }

}
