import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test {
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

    }public static void main(String[] args) {
//        System.out.println(String.join("", Collections.nCopies(2, "И Миру-")));
//        System.out.println(ConsoleView.top10);
//        System.out.println(ConsoleView.mid10);
//        System.out.println(ConsoleView.bottom10);
//
//        List<Integer> nn = new ArrayList();
//
//        nn.add(3);
//        nn.add(34);
//        nn.add(55);
//
//        System.out.println(nn.get(2));
        System.out.println(ConsoleView.mid10);

    }
}
