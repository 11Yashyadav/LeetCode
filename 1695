class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int l = 0, r = 0;
        int curr = 0, ans = 0;

        while (r < nums.length) {
            while (set.contains(nums[r])) {
                curr -= nums[l];
                set.remove(nums[l]);
                l++;
            }
            curr += nums[r];
            set.add(nums[r]);
            ans = Math.max(ans, curr);
            r++;
        }
        return ans;
    }
}
