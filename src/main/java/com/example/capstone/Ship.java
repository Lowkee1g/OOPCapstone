package com.example.capstone;
import java.util.ArrayList;
import java.util.List;

public abstract class Ship {
    //Design pattern: Observer
    private List<ShipObserver> observers = new ArrayList<>();
    private boolean isSunk = false;

    // Existing methods and properties of Ship class

    public void hit() {
        // Logic to determine if the ship is sunk
        if (this.isSunk) {
            notifyObservers();
        }
    }

    public void registerObserver(ShipObserver o) {
        observers.add(o);
    }

    public void removeObserver(ShipObserver o) {
        observers.remove(o);
    }

    protected void notifyObservers() {
        for (ShipObserver observer : observers) {
            observer.update(this);
        }
    }


    //The rest of the class

    private int size;
    private int health;
    private String name;
    private int[][] location;
    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealth() {
        return this.health;
    }
    public void reduceHealth() {
        this.health -= 1;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
