package com.example.capstone;

public class Submarine extends Ship {
    private int size;
    private String name;

    public Submarine() {
        this.setSize(3);
        this.setName("Submarine");
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