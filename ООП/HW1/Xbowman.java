package org.example;

public class Xbowman extends Unit {

    private int shoots;

    public Xbowman() {
        super(6, 3, new int[]{-5, -5}, 10, 4, "Stand");
        shoots = 16;
    }
    @Override
    public String toString() {
        return "Арбалетчик " + super.toString() + ", выстрелы: " + shoots + ", " + state;
    }
}
