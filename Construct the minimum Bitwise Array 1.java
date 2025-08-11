class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            boolean found = false;
            int num = nums.get(i);
            for (int x = 0; x <= num; x++) {
                if ((x | (x + 1)) == num) {
                    ans[i] = x;
                    found = true;
                    break;
                }
            }
            if (!found) {
                ans[i] = -1;
            }
        }
        
        return ans;
    }
}
