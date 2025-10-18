class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        long last = Long.MIN_VALUE;
        int count = 0;

        for (int curr : nums) {
            long low = (long)curr - k;

            if (low > last) {
                last = low;
            } else if ((long)curr + k < last) {
                continue;
            }
            last++;
            count++;
        }
        return count;
    }
}
