package com.example.capstone;

public class AircraftCarrier extends Ship {
    private int size;
    private String name;

    public AircraftCarrier() {
        this.setSize(5);
        this.setName("AircraftCarrier");
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
