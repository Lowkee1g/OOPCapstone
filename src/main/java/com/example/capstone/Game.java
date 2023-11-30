package com.example.capstone;

import com.example.capstone.ships.*;

import java.util.HashMap;
import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        Map playerMap = new Map(10, 10);
        Map enemyMap = new Map(10, 10);
        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, Ship> PlacebleShips = new HashMap<>();
        HashMap<Integer, Ship> shipsLeft = new HashMap<>();
        PlacebleShips.put(1, new Frigate());
        PlacebleShips.put(2, new SpeedBoat());
        PlacebleShips.put(3, new Submarine());
        PlacebleShips.put(4, new AircraftCarrier());
        PlacebleShips.put(5, new Destroyer());

        shipsLeft.putAll(PlacebleShips);


        while (playerMap.getPlacedShips() < 5) {
            //scanner for user input
            playerMap.ShowMap();
            System.out.println("Enter a ship you want to place");

            //prints out all available ships
            for (Integer key : shipsLeft.keySet()) {
                Ship ship = shipsLeft.get(key);
                System.out.println(key + " - " + ship.getName()); // This will print the key and the ship's name
            }

            //gets the shipID from the user
            int shipID = scanner.nextInt();
            System.out.println("you are placing a: " + shipID);
            System.out.println("Enter the coordinates of the ship '0,0': ");
            System.out.println("Then enter the direction of the ship 'UP, DOWN, LEFT, RIGHT': ");

            //gets the coordinates from the user and splits them into an array
            String input = scanner.nextLine(); // This is to clear the buffer
            input = scanner.nextLine();
            String[] coordinates = input.split(",");

            //gets the direction from the user
            Ship.Direction direction = Ship.Direction.valueOf(scanner.nextLine());
            System.out.println("you are placing a: " + shipID + " at " + coordinates[0] + "," + coordinates[1] + " facing " + direction);

            //adds the ship to the map
            playerMap.addShip(shipsLeft.get(shipID), new int[]{Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1])}, direction);

            //removes the ship from the list of ships left to place
            shipsLeft.remove(shipID);
        }


        System.out.println("You have placed all your ships");


        Enemy enemy = new Enemy();
        enemy.setShips(enemyMap);

        playerMap.ShowMap();
        System.out.println("# # # # # # # # # #");
        enemyMap.ShowMap();


        //START OF THE GAME
        Map targetMap = new Map(10, 10);
        StartGame startGame = new StartGame();
        startGame.Start(playerMap, enemyMap, targetMap, enemy);
    }
}
