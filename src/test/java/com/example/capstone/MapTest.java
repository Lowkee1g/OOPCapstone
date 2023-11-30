package com.example.capstone;
import com.example.capstone.Map;
import com.example.capstone.ships.SpeedBoat;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MapTest {
    private Map testMap;

    @Before
    public void setUp() {
        testMap = new Map(10, 10);
    }

    @Test
    public void testMapInitialization() {
        assertEquals("Map should be initialized with width 10", 10, testMap.getWidth());
        assertEquals("Map should be initialized with height 10", 10, testMap.getHeight());
        // Check if all tiles are water initially
        for (int i = 0; i < testMap.getWidth(); i++) {
            for (int j = 0; j < testMap.getHeight(); j++) {
                assertEquals("Initial tiles should be water", Map.Tiles.W, testMap.getTile(new int[]{i, j}));
            }
        }
    }

    @Test
    public void testSetAndGetTile() {
        testMap.setTile(new int[]{0, 0}, Map.Tiles.S);
        assertEquals("Tile at (0, 0) should be a SpeedBoat", Map.Tiles.S, testMap.getTile(new int[]{0, 0}));
    }

    @Test
    public void TestGetShipFromTile() {
        testMap.addShip(new SpeedBoat(), new int[]{0, 0}, Ship.Direction.DOWN);
        testMap.setTile(new int[]{0, 0}, Map.Tiles.S);
        assertEquals("Tile at (0, 0) should be a SpeedBoat", Map.Tiles.S, testMap.getTile(new int[]{0, 0}));
        assertEquals("Tile at (0, 0) should be a SpeedBoat", "SpeedBoat", testMap.getShipFromTile(Map.Tiles.S).getName());
    }
}
