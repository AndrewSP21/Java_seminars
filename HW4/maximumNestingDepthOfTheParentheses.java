public class maximumNestingDepthOfTheParentheses {
    public static void main(String[] args) {
        String s = "(1)+((2())+(((3)))))";
        int max = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                ++count;
                if (count > max) max = count;
            }
            if (s.charAt(i) == ')') {
                --count;
            }
        }
        System.out.println(max);
    }
}
