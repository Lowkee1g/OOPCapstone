//LOKE ANDREAS DINESEN DØJ
//ldoj22@student.aau.dk
package com.example.capstone;
import java.util.ArrayList;
import java.util.List;

public abstract class Ship {
    //Design pattern: Observer
    private List<ShipObserver> observers = new ArrayList<>();
    private boolean isSunk = false;

    public boolean getIsSunk() {
        return isSunk;
    } // Only used for testing
    public void registerObserver(ShipObserver o) {
        observers.add(o);
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
        if (this.getHealth() <= 0) {
            //System.out.println("Notify observers: "+ this.getObserverSize());
            this.isSunk = true;
            notifyObservers();
        }
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
