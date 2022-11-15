import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class containsDuplicateII {
    public static void main(String[] args) {
        System.out.println(ans());
    }
    public static boolean ans(){
        int [] nums = {-24500,-24499,-24498,-24497};
        int k = 3;
        Map<Integer, Integer> s = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (s.containsKey(nums[i])) {
                if (i - s.get(nums[i]) <= k) {
                    return true;
                }
            }
            s.put(nums[i], i);
        }
    return false;
    }
}
