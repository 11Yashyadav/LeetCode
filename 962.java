class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, Comparator.comparingInt(i -> nums[i]));
        
        int maxRamp = 0;
        int minIndex = n;
        
        // Traverse the sorted indices
        for (int idx : indices) {
            maxRamp = Math.max(maxRamp, idx - minIndex);
            minIndex = Math.min(minIndex, idx);
        }
        
        return maxRamp;
    }
}
