class Solution {
    public int[] getNoZeroIntegers(int n) {
        int [] ans =new int[2];
        for(int i =1;i<= (n+1)/2 ;i++){
            int a = n-i;
            int b = i;
            if(!can(a)){
                if(!can(b)){
                    ans[0]=a;
                    ans[1]=b;
                    return ans;
                }
            }
        }
        return ans;
    }
    public static boolean can(int x){
        while(x >0){
            int r = x%10;
            if(r==0) return true;
            x=x/10;
        }
        return false;
    }
}
