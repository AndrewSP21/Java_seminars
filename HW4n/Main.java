import chars.*;

import java.util.*;

public class Main {
    public static final int GANG_SIZE = 10;
    public static List<Base> whiteSide;
    public static List<Base> darkSide;

    public static void main(String[] args) {
        init();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            ConsoleView.view();
            turnMove();
            scanner.nextLine();
        }

    }

    private static void turnMove() {
        List<Base> sortSide = new ArrayList<>();
        sortSide.addAll(whiteSide);
        sortSide.addAll(darkSide);
        sortSide.sort(new Comparator<Base>() {
            @Override
            public int compare(Base o1, Base o2) {
                int tmp = o2.getSpeed() - o1.getSpeed();
                return tmp;
            }
        });
        sortSide.forEach(Base::step);
    }

    private static void init() {
        whiteSide = new ArrayList<>();
        darkSide = new ArrayList<>();

        int x = 1;
        int y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case 0 -> whiteSide.add(new Peasant(whiteSide, darkSide, x, y++));
                case 1 -> whiteSide.add(new Robber(whiteSide, darkSide, x, y++));
                case 2 -> whiteSide.add(new Sniper(whiteSide, darkSide, x, y++));
                default -> whiteSide.add(new Monk(whiteSide, darkSide, x, y++));
            }
        }

        x = GANG_SIZE;
        y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case 0 -> darkSide.add(new Peasant(darkSide, whiteSide, x, y++));
                case 1 -> darkSide.add(new Spearman(darkSide, whiteSide, x, y++));
                case 2 -> darkSide.add(new Xbowman(darkSide, whiteSide, x, y++));
                default -> darkSide.add(new Wizard(darkSide, whiteSide, x, y++));
            }
        }
    }
}