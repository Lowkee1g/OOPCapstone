package com.example.capstone;

public class Frigat implements ship {
    private int size;
    private String name;
    private int[][] location;
    public Frigat() {
        this.setSize(4);
        this.setName("Frigat");
    }
    @Override
    public String toString() {
        return "Frigat";
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
