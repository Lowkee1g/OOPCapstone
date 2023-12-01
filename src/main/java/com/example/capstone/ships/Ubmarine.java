//LOKE ANDREAS DINESEN DØJ
//ldoj22@student.aau.dk
package com.example.capstone.ships;

import com.example.capstone.Ship;

public class Ubmarine extends Ship {
    public Ubmarine() {
        this.setSize(3);
        this.setName("Ubmarine");
        this.setHealth(this.getSize());
    }
}