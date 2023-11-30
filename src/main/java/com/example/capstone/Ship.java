package com.example.capstone;

public abstract class Ship {
    private int size;
    private String name;
    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
