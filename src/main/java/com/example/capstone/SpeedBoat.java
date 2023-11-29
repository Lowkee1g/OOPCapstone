package com.example.capstone;

public class SpeedBoat extends Ship {
    private int size;
    private String name;

    public SpeedBoat() {
        this.setSize(2);
        this.setName("SpeedBoat");
    }

    @Override
    public String toString() {
        return getName();
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
