class Solution {
    public int[] productQueries(int n, int[][] q) {
        String str = Integer.toBinaryString(n);
        char[] ch = str.toCharArray();
        int s1 = str.length();
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = s1-1; i>=0; i--) {
            if (ch[i] == '1') {
                int pow = s1 - 1 - i;
                int num = (int) Math.pow(2, pow);
                arr.add(num);
            }
        }

        int mod = 1_000_000_000 + 7;
        int s = q.length;
        int[] ans = new int[s];

        for (int i = 0; i < s; i++) {
            long m = 1;
            for (int j = q[i][0]; j <= q[i][1]; j++) {
                m = (m * arr.get(j)) % mod;
            }
            ans[i] = (int) m;
        }

        return ans;
    }
}
