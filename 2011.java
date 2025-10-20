class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans =0;
        for(String x : operations){
            if(x.charAt(1)=='-'){
                ans--;
            }
            else{
                ans++;
            }
        }
        return ans;
    }
}
