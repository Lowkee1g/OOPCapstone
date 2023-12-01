//LOKE ANDREAS DINESEN DØJ
//ldoj22@student.aau.dk
package com.example.capstone.ships;

import com.example.capstone.Ship;

public class AircraftCarrier extends Ship {
    public AircraftCarrier() {
        this.setSize(5);
        this.setName("AircraftCarrier");
        this.setHealth(this.getSize());
    }
}
