package com.example.capstone.ships;

import com.example.capstone.Ship;

public class SpeedBoat extends Ship {
    public SpeedBoat() {
        this.setSize(2);
        this.setName("SpeedBoat");
        this.setHealth(this.getSize());
    }
    public void hit() {
        // Specific hit logic for a Battleship
        notifyObservers();
    }
}
