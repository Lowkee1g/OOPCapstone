package com.example.capstone;

public class SpeedBoat implements ship {
    private int size;
    private String name;
    private int[][] location;
    public SpeedBoat() {
        this.setSize(2);
        this.setName("SpeedBoat");
    }
    public String toString() {
        return "SpeedBoat";
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
