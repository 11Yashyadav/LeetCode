public class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, zeroCount = 0, maxLen = 0;
        
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left);
        }
        
        return maxLen;
    }
}
