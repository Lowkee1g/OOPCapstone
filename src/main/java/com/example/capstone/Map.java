package com.example.capstone;

import java.util.Random;

public class Map {
    private int width;
    private int height;
    private int[][] map;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new int[width][height];
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
                System.out.print(this.map[i][j] + " ");
            System.out.println();
        }
    }
}
