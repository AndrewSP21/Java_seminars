package org.example;

public class Xbowman extends Unit {

    private int shoots;

    public Xbowman() {
        super(6, 3, new int[]{-5, -5}, 10, 4, "Stand");
        shoots = 16;
    }
    @Override
    public String getInfo() {
        return "Арбалетчик " + super.getInfo() + ", выстрелы: " + shoots + ", " + state;
    }
}
