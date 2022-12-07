package FirstGame.chars;

import java.util.List;
import java.util.Random;

public class Monk extends Base {
    private boolean magic;
    public Monk(List<Base> gang, List<Base> side, int x, int y) {
        super(12, 7, 0, new int[]{-4,-4}, 30, 5, false, true, "Monk");
        super.gang = gang;
        magic = true;
        super.position = new Vector2(x, y);
        super.side = side;
        quantity = new Random().nextInt(2, 5);
    }
    @Override
    public String getInfo() {
        return "Монах" +  '\t' + super.getInfo();
    }

    @Override
    public void step() {
        double minHealth = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < gang.size(); ++i) {
            if (gang.get(i).health > 0 && gang.get(i).health < gang.get(i).maxHealth) {
                if (gang.get(i).health < minHealth) {
                    minHealth = gang.get(i).health;
                    minIndex = i;
                }
            }
        }
        if (minIndex >= 0) {
            gang.get(minIndex).health -= this.damage[0];
            if(gang.get(minIndex).health > gang.get(minIndex).maxHealth){
                gang.get(minIndex).health = gang.get(minIndex).maxHealth;
            }
        }
    }
}
