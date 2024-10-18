// Give an efficient algorithm that takes values for x1, x2,..., xn and
// s1, s2,..., sn and returns the total number of terabytes processed by
// an optimal solution.

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {

        int[] x = { 10, 1, 7, 7 };
        int[] s = { 8, 4, 2, 1 };

        int n = x.length;
        int result = getNumTB(x, s, n);

        System.out.println("Total number terabytes processed by optimal solution: " + result);
    }

    public static int getNumTB(int[] x, int[] s, int n) {
        int[] optimal = new int[n + 1];
        optimal[0] = 0;
        optimal[1] = Math.min(s[0], x[0]);
        for (int i = 2; i <= n; i++) {
            int m = -1;
            for (int j = 1; j < i; j++) {
                int l = 0;
                for (int k = j; k < i; k++) {
                    l = l + Math.min(s[k - j], x[k]);
                }
                l = l + optimal[j - 1];
                if (l > m) {
                    m = l;
                }
            }
            optimal[i] = m;
        }
        System.out.println(Arrays.toString(optimal));
        return optimal[n];
    }

}
