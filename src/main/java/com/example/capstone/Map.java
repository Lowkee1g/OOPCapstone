package com.example.capstone;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Map {
    public enum Tiles {
        S,
        D,
        U,
        F,
        A,
        W,
        H,
        X
    } // S = SpeedBoat, D = Destroyer, U = Submarine, B = Battleship, A = AircraftCarrier, W = Water, H = Hit
    private int width;
    private int height;
    private List<Ship> ships;
    private int placedShips;
    private Tiles[][] map;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        map = new Tiles[width][height];
        this.ships = new ArrayList<>();
        StartMap();
    }
    public void StartMap() {
        for (int i = 0; i < this.width; i++)
            for (int j = 0; j < this.height; j++)
                map[i][j] = Tiles.W;
    }
    public int getPlacedShips() {
        return this.placedShips;
    }
    public Tiles[][] getTiles() {
        return this.map;
    }

    public Tiles getTile(int[] location) {
        return this.map[location[0]][location[1]];
    }
    public void setTile(int[] location, Tiles tile) {
        this.map[location[0]][location[1]] = tile;
    }

    public void setPlacedShips() {
        this.placedShips += 1;
    }

    public Ship getShipFromTile(Tiles tile) {
        System.out.println("HIT " + tile.toString());
        for (Ship ship : ships) {
            if (ship.getName().substring(0,1).equals(tile.toString())) {
                return ship;
            }
        }
        return null;
    }
    public List<Ship> getShips() {
        return this.ships;
    }

    public void removeShip(Ship ship) {
        this.ships.remove(ship);
    }
    public void setObserver(StartGame startGame) {
        for (Ship ship : ships) {
            ship.registerObserver(startGame);
        }
    }


    public void addShip(Ship ship, int[] location, Ship.Direction direction) {
        addShipToList(ship);
        try {
            switch (direction) {
                case UP: // Transposed UP is LEFT
                    for (int i = 0; i < ship.getSize(); i++) {
                        map[location[0]][location[1] - i] = Tiles.valueOf(ship.getName().substring(0, 1));
                    }
                    break;
                case DOWN: // Transposed DOWN is RIGHT
                    for (int i = 0; i < ship.getSize(); i++) {
                        map[location[0]][location[1] + i] = Tiles.valueOf(ship.getName().substring(0, 1));
                    }
                    break;
                case LEFT: // Transposed LEFT is UP
                    for (int i = 0; i < ship.getSize(); i++) {
                        map[location[0] - i][location[1]] = Tiles.valueOf(ship.getName().substring(0, 1));
                    }
                    break;
                case RIGHT: // Transposed RIGHT is DOWN
                    for (int i = 0; i < ship.getSize(); i++) {
                        map[location[0] + i][location[1]] = Tiles.valueOf(ship.getName().substring(0, 1));
                    }
                    break;
            }
            setPlacedShips();
            System.out.println("You have placed " + getPlacedShips() + " ships");
        } catch (Exception e) {
            System.out.println("You are most likely trying to place a ship outside the map, Error: " + e);
        }
    }




    public void addShipToList(Ship ship) {
        this.ships.add(ship);
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }


    public void ShowMap() {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++)
                switch (map[j][i]) {
                    case W -> System.out.print(TerminalColors.BLUE + "W ");
                    case S -> System.out.print(TerminalColors.YELLOW + "S ");
                    case A -> System.out.print(TerminalColors.YELLOW + "A ");
                    case D -> System.out.print(TerminalColors.YELLOW + "D ");
                    case U -> System.out.print(TerminalColors.YELLOW + "U ");
                    case F -> System.out.print(TerminalColors.YELLOW + "F ");
                    case H -> System.out.print(TerminalColors.RED + "H ");
                    case X -> System.out.print(TerminalColors.RESET + "X ");
                }
            System.out.println(TerminalColors.RESET);
        }
    }
}
