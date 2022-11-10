import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class removeOutermostParentheses {
    public static void main(String[] args) {
        String s ="()()";
        StringBuilder ans = new StringBuilder("");
        int count = 0;
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                deque.add(s.charAt(i));
                ++count;
            } else {
                deque.add(s.charAt(i));
                --count;
            }
            if (count == 0){
                deque.pollFirst();
                deque.pollLast();
                while (!deque.isEmpty()){
                    ans.append(deque.pollFirst());
                }

            }
        }
        System.out.println(ans.toString());
    }
}
