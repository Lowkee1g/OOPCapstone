package com.example.capstone;

public interface ship {
    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public void setSize(int size);

    public int getSize();

    public void setName(String name);

    public String getName();
}
