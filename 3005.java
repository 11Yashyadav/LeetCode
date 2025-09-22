class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int x : nums){
            mp.put(x,mp.getOrDefault(x,0)+1); //
        }
        int max =0;
        for(Map.Entry<Integer,Integer> ent : mp.entrySet()){
            max=Math.max(max,ent.getValue());
        }
        int ans =0;
        for(Map.Entry<Integer,Integer> ent : mp.entrySet()){
            if(ent.getValue()== max){
                ans+= max;
            }
        }
        return ans;
    }
}
