package FirstGame.chars;

import java.util.List;
import java.util.Random;

public class Sniper extends Base {
    private int shots;
    public Sniper(List<Base> gang, List<Base> side, int x, int y) {

        super(12, 10, 32, new int[]{8,10}, 15, 9, false, false, "Sniper");
        shots = 32;
        super.gang = gang;
        super.position = new Vector2(x, y);
        super.side = side;
        quantity = new Random().nextInt(1, 3);
    }
    @Override
    public String getInfo() {
        return "Снайпер" +  '\t'  + super.getInfo() + "sh:" + shots;
    }
    @Override
    public void step() {
        for (Base base: gang) {
            if(base.getName().equals("Peasant")){
                this.shots++;
                base.setAction("Занят");
                break;
            }
        }
        if (this.shots > 0) {
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
}
