package com.example.capstone.ships;

import com.example.capstone.Ship;

public class Submarine extends Ship {
    public Submarine() {
        this.setSize(3);
        this.setName("Ubmarine");
        this.setHealth(this.getSize());
    }
}