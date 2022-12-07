package FirstGame.chars;

import java.util.Arrays;
import java.util.List;
import FirstGame.AnsiColors;

public abstract class Base implements BaseInterface {
//    public static final String ANSI_RED = "\u001B[31m";
//    public static final String ANSI_RESET = "\u001B[0m";

    private int attack;
    private int defence;
    private int shoot;
    protected int[] damage;
    protected double health;
    protected double maxHealth;
    protected int speed;
    private boolean delivery;
    private boolean magic;
    private String name;
    private String status;
    private static int idCounter;
    private int playerID;
    protected String action;
    protected List<Base> gang, side;
    protected Vector2 position;
    protected int quantity;

    public Base(int attack, int defence, int shoot, int[] damage, double health, int speed, boolean delivery, boolean magic, String name) {
        this.attack = attack;
        this.defence = defence;
        this.shoot = shoot;
        this.damage = damage;
        this.health = health;
        this.maxHealth = health;
        this.speed = speed;
        this.delivery = delivery;
        this.magic = magic;
        this.name = name;
        this.action = "Стоит";
        playerID = idCounter++;
//        quantity = new Random().nextInt(1,20);
    }

    public Vector2 getPosition() {
        return position;
    }

    public int getPlayerID() {
        return playerID;
    }

    public double getHealth() {
        return health;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public float calcDamage(Base unit) {
        if (unit.defence - this.attack == 0) {
            return ((this.damage[0] + this.damage[1]) / 2.0f) * quantity;
        }
        if (unit.defence - this.attack < 0) {
            return (this.damage[0]) * quantity;
        }
        return (this.damage[1]) * quantity;
    }

    public void getHit(float damage){
//        this.health -= damage;
//        if (this.health <= 0){
//            this.health = 0;
//            this.action = "Мертв";
//        }
        double tmpHealth = (quantity - 1) * maxHealth + health;
        tmpHealth -= damage;
        if (tmpHealth <= 0){
            this.health = 0;
            this.action = "Мертв";
            quantity = 0;
        } else {
            quantity = (int)(tmpHealth / maxHealth);
            health = maxHealth;
            if (tmpHealth % maxHealth > 0){
                quantity++;
                health = tmpHealth % maxHealth;
            }
        }
    }

    public String getAction() {
        return action;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getInfo() {
        if (action.equals("Мертв")){
            return " a:" + attack +
                    " p:" + defence +
                    " s:" + shoot +
                    " d:" + Arrays.toString(damage) +
                    " h:" + health +
                    " s:" + speed +
                    " d:" + delivery +
                    " m:" + magic +
                    " St:" + AnsiColors.ANSI_RED + action + AnsiColors.ANSI_RESET +
                    "{" + quantity + "}";
        } else {
            return " a:" + attack +
                    " p:" + defence +
                    " s:" + shoot +
                    " d:" + Arrays.toString(damage) +
                    " h:" + health +
                    " s:" + speed +
                    " d:" + delivery +
                    " m:" + magic +
                    " St:" + action +
                    "{" + quantity + "}";
        }
    }
// String.format("? %d\t\uD83D\uDEE1 %d\t?%.1f\t?%d", attack,protect,health,(damage[0] + damage[1])/2,speed);

    @Override
    public void step() {
//        int index = 0;
//        float dist = Float.MAX_VALUE;
//        for (int i = 0; i < gang.size(); i++) {
//            if (Math.abs(position.x - gang.get(i).position.x) >= 1){
//                index = i;
//                dist = ....
//            }
//        }
//        position.x++;
    }

}