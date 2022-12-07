package FirstGame.chars;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Monk extends Base {
    private boolean magic;
    static int tmpInt = -1;

    public Monk(List<Base> gang, List<Base> side, int x, int y) {
        super(12, 7, 0, new int[]{-4, -4}, 30, 5, false, true, "Monk");
        super.gang = gang;
        magic = true;
        super.position = new Vector2(x, y);
        super.side = side;
        quantity = new Random().nextInt(2, 5);
    }

    @Override
    public String getInfo() {
        return "Монах" + '\t' + super.getInfo();
    }

    @Override
    public void step() {
//        double minHealth = Integer.MAX_VALUE;
        Map<Integer, Double> healths = new HashMap<>();
        for (int i = 0; i < gang.size(); i++) {
            healths.put(i, gang.get(i).health / gang.get(i).maxHealth);
        }
        List<Double> a = new ArrayList<>(healths.values().stream().toList());
        Collections.sort(a);
        healths.forEach((index, value) -> {
            if (value.equals(a.get(0))) {
                tmpInt = index;
            }
        });

        if (a.get(0) > 0.5) {
            double dist = 1;
            int index = -1;
            for (int i = 0; i < side.size(); i++) {
                if (side.get(i).action.equals("Мертв")) {
                    continue;
                }
                if (side.get(i).health / side.get(i).maxHealth < dist) {
                    dist = side.get(i).health / side.get(i).maxHealth;
                    index = 1;
                }
            }
            if (index < 0) {
                index = 0;
            }
            side.get(index).getHit(damage[0] * (-1));
            action = "Выстрелил в " + index;
            return;
        }
        if (a.get(0).equals(0.0)) {
            tmpInt = -1;
            healths.forEach((index, value) -> {
                if (value.equals(0.0)) {
                    if (gang.get(index).getName().equals("Sniper") || gang.get(index).getName().equals("Monk")) {
                        tmpInt = index;
                    }
                }
            });
            if (tmpInt >= 0){
                gang.get(tmpInt).health = 1;
                gang.get(tmpInt).action = "Стоит";
                gang.get(tmpInt).quantity = 1;
                action = "Возродил " + tmpInt;
            }
            return;

        }

        if (a.get(0) <= 0.5) {
            gang.get(tmpInt).health -= this.damage[0];
            if (gang.get(tmpInt).health > gang.get(tmpInt).maxHealth) {
                gang.get(tmpInt).health = gang.get(tmpInt).maxHealth;
            }
            action = "Вылечил " + tmpInt;
        }

//        for (int i = 0; i < gang.size(); ++i) {
//            if (gang.get(i).health > 0 && gang.get(i).health < gang.get(i).maxHealth) {
//                if (gang.get(i).health < minHealth) {
//                    minHealth = gang.get(i).health;
//                    minIndex.set(i);
//                }
//            }
//        }
//        if (minIndex.get() >= 0) {
//            gang.get(minIndex.get()).health -= this.damage[0];
//            if (gang.get(minIndex.get()).health > gang.get(minIndex.get()).maxHealth) {
//                gang.get(minIndex.get()).health = gang.get(minIndex.get()).maxHealth;
//            }
//        }
    }
}
