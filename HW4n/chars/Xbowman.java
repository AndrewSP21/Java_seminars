package chars;

import java.util.List;

public class Xbowman extends Base {

    private int shots;
    public Xbowman(List<Base> gang, List<Base> side, int x, int y) {
        super(6, 3, 16, new int[]{2,3}, 10, 4, false, false, "Xbowman");
        shots = 16;
        super.gang = gang;
        super.position = new Vector2(x, y);
        super.side = side;
    }

    @Override
    public void step() {
        for (Base base: super.gang) {
            if(base.getName().equals("Peasant")){
                if (!base.getAction().equals("Занят") && !base.getAction().equals("Мертв")) {
                    shots++;
                    base.setAction("Занят");
                    break;
                }
            }
        }
        if (shots > 0) {
            double dist = Double.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < side.size(); i++) {
                double tmp = side.get(i).getPosition().getDist(this.position);
                if (dist > tmp && !side.get(i).getAction().equals("Мертв")){
                    dist = tmp;
                    index = i;
                }
            }

            if(index >= 0){
                side.get(index).getHit(speed > dist ? calcDamage(side.get(index)): calcDamage(side.get(index))/2);
                shots--;

            }
            shots--;
        }
    }

    @Override
    public String getInfo() {
        return "Арбалетчик" +  '\t'  + super.getInfo() + " sh:" + shots;
    }
}
