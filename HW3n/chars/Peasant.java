package chars;

import java.util.List;

public class Peasant extends Base {

    private boolean delivery;
    public Peasant(List<Base> gang, int x, int y) {
        super(1, 1, 0, new int[]{1,1}, 1, 3, true, false, "Peasant");
        delivery = true;
        super.gang = gang;
        super.position = new Vector2(x, y);
    }
    @Override
    public String getInfo() {
        return "????????" +  '\t' + super.getInfo();
    }
}
