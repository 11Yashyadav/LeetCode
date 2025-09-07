class Solution {
    public int[] sumZero(int n) {
       
       int[] ans = new int[n];
       if(n%2==0){
        int start = (n/2);
        for(int i =0;i<n;i++){
            ans[i]= start;
            start--;
            if(start==0)start--;
        }
       }else{
        int start = (n/2);
        for(int i =0;i<n;i++){
            ans[i]= start;
            start--;
            
        }
       }
       return ans;
    }
}
