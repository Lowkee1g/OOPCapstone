//LOKE ANDREAS DINESEN DØJ
//ldoj22@student.aau.dk
package com.example.capstone.ships;

import com.example.capstone.Ship;

public class Destroyer extends Ship {
    public Destroyer() {
        this.setSize(3);
        this.setName("Destroyer");
        this.setHealth(this.getSize());
    }
}
