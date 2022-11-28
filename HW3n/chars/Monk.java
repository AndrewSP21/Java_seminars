package chars;

import java.util.List;

public class Monk extends Base {
    private boolean magic;
    public Monk(List<Base> gang, int x, int y) {
        super(12, 7, 0, new int[]{-4,-4}, 30, 5, false, true, "Monk");
        super.gang = gang;
        magic = true;
        super.position = new Vector2(x, y);
    }
    @Override
    public String getInfo() {
        return "Монах" +  '\t' + super.getInfo();
    }

}
