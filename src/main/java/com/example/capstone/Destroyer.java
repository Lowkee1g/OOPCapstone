package com.example.capstone;

public class Destroyer extends Ship {
    private int size;
    private String name;

    public Destroyer() {
        this.setSize(3);
        this.setName("Destroyer");
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
