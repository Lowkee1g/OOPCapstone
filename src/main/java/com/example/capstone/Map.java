package com.example.capstone;

import java.util.List;
import java.util.Random;


public class Map {
    enum Tiles {
        S,
        D,
        U,
        F,
        A,
        W,
        H
    } // S = SpeedBoat, D = Destroyer, U = Submarine, B = Battleship, A = AircraftCarrier, W = Water, H = Hit
    private int width;
    private int height;
    private List<ship> ships;
    private Tiles[][] map;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        map = new Tiles[width][height];
        StartMap();
    }
    public void StartMap() {
        for (int i = 0; i < this.width; i++)
            for (int j = 0; j < this.height; j++)
                map[i][j] = Tiles.W;
    }

    public void addShip(ship ship, int[][] location, ship.Direction direction) {
        try {
            switch (direction) {
                case UP: // Transposed UP is LEFT
                    for (int i = 0; i < ship.getSize(); i++) {
                        map[location[0][0]][location[0][1] - i] = Tiles.valueOf(ship.getName().substring(0, 1));
                    }
                    break;
                case DOWN: // Transposed DOWN is RIGHT
                    for (int i = 0; i < ship.getSize(); i++) {
                        map[location[0][0]][location[0][1] + i] = Tiles.valueOf(ship.getName().substring(0, 1));
                    }
                    break;
                case LEFT: // Transposed LEFT is UP
                    for (int i = 0; i < ship.getSize(); i++) {
                        map[location[0][0] - i][location[0][1]] = Tiles.valueOf(ship.getName().substring(0, 1));
                    }
                    break;
                case RIGHT: // Transposed RIGHT is DOWN
                    for (int i = 0; i < ship.getSize(); i++) {
                        map[location[0][0] + i][location[0][1]] = Tiles.valueOf(ship.getName().substring(0, 1));
                    }
                    break;
            }
        } catch (Exception e) {
            System.out.println("You are most likely trying to place a ship outside the map, Error: " + e);
        }
    }




    public void setShips(List<ship> ships) {
        this.ships = ships;
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
                }
            System.out.println(TerminalColors.RESET);
        }
    }
}
