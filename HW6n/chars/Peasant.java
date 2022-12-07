package FirstGame.chars;

import java.util.List;
import java.util.Random;

public class Peasant extends Base {

    private boolean delivery;
    public Peasant(List<Base> gang, List<Base> side, int x, int y) {
        super(1, 1, 0, new int[]{1,1}, 1, 3, true, false, "Peasant");
        delivery = true;
        super.gang = gang;
        super.position = new Vector2(x, y);
        super.side = side;
        quantity = new Random().nextInt(3, 6);
    }
    @Override
    public String getInfo() {
        return "Крестьянин" +  '\t' + super.getInfo();
    }

    @Override
    public void step() {
        if (action.equals("Занят")) {
            action = "Стоит";
        }
    }
}
