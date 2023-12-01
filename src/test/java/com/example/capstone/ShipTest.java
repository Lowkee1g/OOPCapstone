//LOKE ANDREAS DINESEN DØJ
//ldoj22@student.aau.dk
package com.example.capstone;

import com.example.capstone.ships.*;
import org.junit.Before;
import org.junit.Test;

public class ShipTest {
    Ship ship;
    @Before
    public void setUp() {
        ship = new SpeedBoat();
    }

    @Test
    public void testShip() {
        assert(ship.getHealth() == 2);
        assert(ship.getSize() == 2);
        assert(ship.getName().equals("SpeedBoat"));
    }

    @Test
    public void testReduceHealth() {
        ship.reduceHealth();
        assert(ship.getHealth() == 1);
    }

    @Test
    public void testIsSunk() {
        ship.reduceHealth();
        ship.reduceHealth();
        assert(ship.getIsSunk());
    }
}
