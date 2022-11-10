import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Valid_Parentheses {
    public static void main(String[] args) {
        String s = "((()[]{)})[]";

        Stack<Character> stackR = new Stack<Character>();
        Boolean ans = true;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case '(':
                case '{':
                case '[':
                    stackR.add(s.charAt(i));
                    break;
                default:
                    break;
            }
            if (stackR.isEmpty()) {
                ans = false;
                break;
            }
            switch (s.charAt(i)){
                case ')':
                    if (stackR.peek() == '(') {
                        stackR.pop();
                    } else {
                        ans = false;
                    }
                    break;
                case '}':
                    if (stackR.peek() == '{') {
                        stackR.pop();
                    } else {
                        ans = false;
                    }
                    break;
                case ']':
                    if (stackR.peek() == '[') {
                        stackR.pop();
                    } else {
                        ans = false;
                    }
                    break;
                default:
                    break;
            }
            if (!ans) break;
        }
        if (!stackR.isEmpty()) ans = false;
        System.out.println(stackR);
        System.out.println(ans);
    }
}
