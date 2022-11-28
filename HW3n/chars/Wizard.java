package chars;

import java.util.List;

public class Wizard extends Base {
    private boolean magic;
    public Wizard(List<Base> gang, int x, int y) {
        super(17, 12, 0, new int[]{-5,-5}, 30, 9, false, true, "Wizard");
        magic = true;
        super.gang = gang;
        super.position = new Vector2(x, y);
    }
    @Override
    public String getInfo() {
        return "Колдун "  +  '\t' + super.getInfo();
    }
}
