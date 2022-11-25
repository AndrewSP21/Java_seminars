package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final int GANG_SIZE = 10;

    public static void main(String[] args) {
//        List<Unit> units = new ArrayList<>();
//        for (int i = 0; i < 50; i++) {
//            units.add(getUnit());
//        }
//        getType(units, "Разбойник");
        List<Unit> whiteSide = new ArrayList<>();
        List<Unit> blackSide = new ArrayList<>();


        while (whiteSide.size() < GANG_SIZE) {
            whiteSide.add(getUnit(0, whiteSide));
            blackSide.add(getUnit(3, blackSide));

        }
        whiteSide.forEach(unit -> System.out.println(unit.getInfo()));
        System.out.println();
        blackSide.forEach(unit -> System.out.println(unit.getInfo()));
        System.out.println();
        whiteSide.forEach(Unit::step);
        blackSide.forEach(Unit::step);
        System.out.println();

        whiteSide.forEach(unit -> System.out.println(unit.getInfo()));
        System.out.println();
        blackSide.forEach(unit -> System.out.println(unit.getInfo()));
    }

    private static Unit getUnit(int origin, List<Unit> side) {
        int num = new Random().nextInt(origin, origin + 4);
        return switch (num) {
            case 0 -> new Monk(side);
            case 1 -> new Robber();
            case 2 -> new Sniper();
            case 3 -> new Peasant();
            case 4 -> new Spearman();
            case 5 -> new Wizard(side);
            default -> new Xbowman();
        };
    }

    private static void getType(List<Unit> units, String type) {
        for (Unit unit : units) {
            if (unit.toString().split(" ")[0].equals(type)) {
                //result.add(unit);
                System.out.println(unit);
            }

        }
    }
}