public class powx {
    public static void main(String[] args) {

        int k = -1;
        System.out.println(myPow(2,k));
        System.out.println(Math.pow(2,k));
//        System.out.println(myPow(7.5, 5));

    }
    public static double onePow(double x, int n) {
        if (n == 1){
            return x;
        } else return 1;
    }

    public static double box(double x) {
        return x * x;
    }
    public static boolean controlN(int n) {
        if (n > 0) {
            return true;
        } else return false;

    }

    public static double myPow(double x, int m ) {
        int n;
        if (controlN(m)) {
            n = m;
            return miniPow(x, n);
        } else {
            n = (-1) * m;
            return 1 / miniPow(x, n);
        }
    }

    public static double miniPow(double x, int m ){
        if (m == 0 || x == 1) return 1;
        if (m == 1) return x;
        if (m == -1) return 1 / x;
        if (x == 0) return 0;
        String xBin = Integer.toBinaryString(m);
        int idx = 0;
        double res = 1;
        double pow1 = 1;
        while (idx < xBin.length() - 1){
            pow1 = onePow(x, xBin.charAt(idx) - '0');
            res = box(res * pow1 );
            idx ++;
        }
        return res * onePow(x, xBin.charAt(xBin.length() - 1) - '0');
    }
}
