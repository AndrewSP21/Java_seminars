import java.util.HashMap;
import java.util.Map;

public class romanToInteger {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        Map<String, Integer> romanNum = new HashMap<>((Map.of("I", 1, "V", 5, "X", 10, "L", 50, "C", 100, "D", 500, "M", 1000)));
        Integer ans = romanNum.get(String.valueOf(s.charAt(s.length() - 1)));

        if (s.length() == 1) {
            System.out.println(ans);
        }
         for (int i = s.length() - 2; i >= 0; i--) {
            Integer charN = romanNum.get(String.valueOf(s.charAt(i)));
            Integer charN1 = romanNum.get(String.valueOf(s.charAt(i + 1)));
            if (charN >= charN1) {
                ans = ans + charN;
            } else {
                ans = ans - charN;
            }
        }

        System.out.println(ans);
    }
}
