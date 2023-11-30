package com.example.capstone;

import java.util.HashMap;
import java.util.Scanner;

public class StartGame implements ShipObserver {
    //Design pattern: Observer
    @Override
    public void update(Ship ship) {
        System.out.println(ship.getClass().getSimpleName() + " has been sunk!");
    }

    private boolean turn = true;
    private int winningCondition = 0;
    private int[] location;
    public void Start(Map playerMap, Map enemyMap, Map targetMap, Enemy enemy) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Battleship!");
        System.out.println("This is your map:");
        playerMap.ShowMap();
        System.out.println("This is your target map:");
        targetMap.ShowMap();
        System.out.println("you need to find and destroy the enemy ships");
        System.out.println("The enemy has 5 ships, a SpeedBoat, a Destroyer, a Submarine, a AircraftCarrier and a Frigate");
        System.out.println("you can do the following actions:");
        System.out.println("1. Fire a shot");
        System.out.println("2. View your map");
        System.out.println("3. View your target map");
        System.out.println("if you want to fire a shot, enter a coordinate like this: 0,0");
        while (winningCondition == 0) {
            //Player turn
            while (turn) {
                String shot = "";
                while (shot.isEmpty()) {
                    int input;
                    input = scanner.nextInt();
                    scanner.nextLine();// This is to clear the buffer

                    while (input < 1 || input > 3) {
                        System.out.println("Please enter a valid number");
                        input = scanner.nextInt();
                        scanner.nextLine();// This is to clear the buffer
                    }

                    switch (input) {
                        case 1 -> {
                            System.out.println("Enter the coordinates of the shot: ");
                            shot = scanner.nextLine();
                            //scanner.nextLine();// This is to clear the buffer
                            System.out.println("You fired a shot at: " + shot);
                        }
                        case 2 -> {
                            System.out.println("This is your map:");
                            playerMap.ShowMap();
                        }
                        case 3 -> {
                            System.out.println("This is your target map:");
                            targetMap.ShowMap();
                        }
                    }
                }

                String[] coordinates = shot.split(",");

                int[] location = new int[]{Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1])};

                if (enemyMap.getTile(location) == Map.Tiles.W) {
                    System.out.println("SPLASH! you hit the water");
                    targetMap.setTile(location, Map.Tiles.X);
                    enemyMap.setTile(location, Map.Tiles.X);
                } else {
                    System.out.println("BOOM! you hit a ship");

                    Map.Tiles tile = enemyMap.getTile(location);
                    Ship ship = enemyMap.getShipFromTile(tile);


                    ship.reduceHealth();
                    if (ship.getHealth() == 0) {
                        System.out.println("You sunk a ship");
                        enemyMap.removeShip(ship);
                    }

                    //Change the visual of the map
                    targetMap.setTile(location, Map.Tiles.H);
                    enemyMap.setTile(location, Map.Tiles.H);
                }
                //Gives the turn to the enemy
                turn = false;
            }


            //Enemy turn
            do {
                location = new int[]{(int) (Math.random() * playerMap.getHeight()), (int) (Math.random() * playerMap.getWidth())};
            } while (Map.Tiles.valueOf(playerMap.getTile(location).toString()) == Map.Tiles.H || Map.Tiles.valueOf(playerMap.getTile(location).toString()) == Map.Tiles.X);



            if (playerMap.getTile(location) == Map.Tiles.W) {
                System.out.println("SPLASH! the enemy hit the water");
                playerMap.setTile(location, Map.Tiles.X);
            } else {
                System.out.println("BOOM! the enemy hit a ship");

                Map.Tiles tile = playerMap.getTile(location);
                Ship ship = playerMap.getShipFromTile(tile);
                System.out.println(ship);

                ship.reduceHealth();
                if (ship.getHealth() == 0) {
                    System.out.println("The enemy sunk a ship");
                    playerMap.removeShip(ship);

                }
            }
            turn = true;
            if (playerMap.getShips().isEmpty()) {
                winningCondition = 1;
            } else if (enemyMap.getShips().isEmpty()) {
                winningCondition = 2;
            }
        }
        if (winningCondition == 1) {
            System.out.println("You lost!");
        } else if (winningCondition == 2) {
            System.out.println("You won...");
        }
    }
}
