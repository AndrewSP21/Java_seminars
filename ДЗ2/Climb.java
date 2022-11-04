public class Climb {
    public static void main(String[] args) {

        System.out.println(climbStairs(5));
    }
    public static int climbStairs(int n) {
        int a = 0;
        int b = 1;
        int a1 = 0;
        for (int i = 1; i <= n; i++){
            a1 = a;
            a = b;
            b = a1 + b;
        }
        return b;
    }
}
