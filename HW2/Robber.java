package org.example;

public class Robber extends Unit {

    public Robber() {
        super(8, 3, new int[]{2, 4}, 10, 6, "Stand");
    }

    @Override
    public String getInfo() {
        return "Разбойник " + super.getInfo() + ", " + state;
    }
}
