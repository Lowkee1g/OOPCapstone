package com.example.capstone;

public abstract class Ship {
    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public abstract void setSize(int size);

    public abstract int getSize();

    public abstract void setName(String name);

    public abstract String getName();
}
