class Solution {
    private long solve(long a, long b) {
        long L = 1;
        long s = 1;
        long res = 0;

        while (L <= b) {
            long R = 4 * L - 1;
            long maxi = Math.max(L, a);
            long mini = Math.min(R, b);

            if (maxi <= mini) {
                res += (mini - maxi + 1) * s;
            }

            L = L * 4;
            s++;
        }
        return res;
    }

    public long minOperations(int[][] queries) {
        long cnt = 0;
        for (int[] q : queries) {
            long a = q[0], b = q[1];
            long s = solve(a, b);
            cnt += (s + 1) / 2;
        }
        return cnt;
    }
}
