class Solution {
    Double[][] memo;
    public double soupServings(int n) {
        if (n > 4800) return 1.0;
       n = (int) Math.ceil(n / 25.0);
        memo = new Double[n + 1][n + 1];
        return help(n, n);
    }

    public double help(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;

        if (memo[a][b] != null) return memo[a][b];

        double l1 = help(a - 4, b);
        double l2 = help(a - 3, b - 1);
        double l3 = help(a - 2, b - 2);
        double l4 = help(a - 1, b - 3);

        memo[a][b] = 0.25 * (l1 + l2 + l3 + l4);
        return memo[a][b];
    }
}
