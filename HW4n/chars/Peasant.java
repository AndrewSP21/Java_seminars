package chars;

import java.util.List;

public class Peasant extends Base {

    private boolean delivery;
    public Peasant(List<Base> gang, List<Base> side, int x, int y) {
        super(1, 1, 0, new int[]{1,1}, 1, 3, true, false, "Peasant");
        delivery = true;
        super.gang = gang;
        super.position = new Vector2(x, y);
        super.side = side;

    }
    @Override
    public String getInfo() {
        return "Крестьян" +  '\t' + super.getInfo();
    }

    @Override
    public void step() {
        if (action.equals("Занят")) {
            action = "Стоит";
        }
    }
}
