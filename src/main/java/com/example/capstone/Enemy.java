package com.example.capstone;

public class Enemy {

    public Enemy() {

    }

    public void setShips(Map map) {
        map.addShip(new Frigate(), new int[]{0, 5}, Ship.Direction.DOWN);
        map.addShip(new SpeedBoat(), new int[]{0, 0}, Ship.Direction.RIGHT);
        map.addShip(new Submarine(),new int[]{6, 2}, Ship.Direction.RIGHT);
        map.addShip(new AircraftCarrier(), new int[]{9, 9}, Ship.Direction.LEFT);
        map.addShip(new Destroyer(), new int[]{6, 6}, Ship.Direction.DOWN);
    }

}
