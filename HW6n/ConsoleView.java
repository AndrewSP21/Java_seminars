package FirstGame;

import FirstGame.chars.Vector2;

import java.util.Collections;

public class ConsoleView {

    private static int step = 1;
     static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(Main.GANG_SIZE-1, formatDiv("-b")))+formatDiv("-c");
    static final String mid10 = formatDiv("d") + String.join("", Collections.nCopies(Main.GANG_SIZE-1, formatDiv("-e")))+formatDiv("-f");
    static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(Main.GANG_SIZE-1, formatDiv("-h")))+formatDiv("-i");

    public static void view(){
        if (step == 1) {
            System.out.println(AnsiColors.ANSI_RED+"First step."+AnsiColors.ANSI_RESET);
        } else {
            System.out.println(AnsiColors.ANSI_RED+"Step ¹" + step +"."+AnsiColors.ANSI_RESET);
        }
        step++;

        System.out.println(ConsoleView.top10);

        for (int i = 1; i <= Main.GANG_SIZE-1; i++) {
            for (int j = 1; j <= Main.GANG_SIZE; j++) {
                System.out.print(getChar(new Vector2(j, i)));
            }
            System.out.print("|");
            for (int j = 1; j <= Main.GANG_SIZE; j++) {
                System.out.print(getHeroInfo(new Vector2(j, i)));
            }
            System.out.println();
            System.out.println(ConsoleView.mid10);
        }

        for (int j = 1; j <= Main.GANG_SIZE; j++) {
            System.out.print(getChar(new Vector2(j, Main.GANG_SIZE)));
        }
        System.out.print("|");
        for (int j = 1; j <= Main.GANG_SIZE; j++) {
            System.out.print(getHeroInfo(new Vector2(j, Main.GANG_SIZE)));
        }
        System.out.println();
        System.out.println(ConsoleView.bottom10);
        System.out.println("Press Enter.");
    }
    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500')
                .replace("S", "...")
                .replace("O", "---");
    }
    private static String getChar(Vector2 position){
        String str = "| ";
        for (int i = 0; i < Main.GANG_SIZE; i++) {
            if (Main.darkSide.get(i).getPosition().isEquals(position)) str = "|"+AnsiColors.ANSI_BLUE + Main.darkSide.get(i).getName().toUpperCase().charAt(0) + AnsiColors.ANSI_RESET;
            if (Main.whiteSide.get(i).getPosition().isEquals(position)) str = "|" + AnsiColors.ANSI_GREEN + Main.whiteSide.get(i).getName().toUpperCase().charAt(0) + AnsiColors.ANSI_RESET;
        }
        return str;
    }

    private static String getHeroInfo(Vector2 position){
        String str = " ";
        int maxLengthWhite = 0;
        for (int i = 0; i < Main.whiteSide.size(); i++) {
            if (Main.whiteSide.get(i).getInfo().length() >  maxLengthWhite) {
                maxLengthWhite = Main.whiteSide.get(i).getInfo().length();
            }
        }

        maxLengthWhite += 10;
        for (int i = 0; i < Main.GANG_SIZE; i++) {
            if (Main.darkSide.get(i).getPosition().isEquals(position)) {
                str = AnsiColors.ANSI_BLUE + Main.darkSide.get(i).getInfo() + AnsiColors.ANSI_RESET + " ".repeat(5);
            }
            if (Main.whiteSide.get(i).getPosition().isEquals(position)) {
//                int k = maxLengthWhite - FirstGame.Main.whiteSide.get(i).getInfo().length();
                str = AnsiColors.ANSI_GREEN + Main.whiteSide.get(i).getInfo() + AnsiColors.ANSI_RESET;// + " ".repeat( k );
                str += " ".repeat(maxLengthWhite - str.length());
            }
        }

        return str;
    }

}
