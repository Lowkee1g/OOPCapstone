//LOKE ANDREAS DINESEN DØJ
//ldoj22@student.aau.dk


package com.example.capstone;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnemyTest {
    Map testMap;

    @Before
    public void setUp() {
        testMap = new Map(10, 10);
    }

    @Test
    public void testSetShips() {
        Enemy enemy = new Enemy();
        enemy.setShips(testMap);
        assertEquals("Map should have 5 ships", 5, testMap.getPlacedShips());
    }
}
