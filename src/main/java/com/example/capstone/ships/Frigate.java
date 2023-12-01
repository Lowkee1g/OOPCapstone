//LOKE ANDREAS DINESEN DØJ
//ldoj22@student.aau.dk
package com.example.capstone.ships;

import com.example.capstone.Ship;

public class Frigate extends Ship {
    public Frigate() {
        this.setSize(4);
        this.setName("Frigate");
        this.setHealth(this.getSize());
    }
}
