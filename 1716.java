class Solution {
    public int totalMoney(int n) {
        int w = n/7;
        int r = n % 7;
        int sumFull = 28*w + 7*(w*(w-1)/2);
        int SumRem = r*w + r*(r+1)/2;
        return sumFull + SumRem;
    }
}
/* Another approch to understand
class Solution {
    public int totalMoney(int n) {
        int ans =0;
        int mod = n/7;
        int rem = n%7;
        for(int i =0;i<mod;i++){
            for(int j=1;j<=7;j++){
                ans+=i+j;
            }
        }
        for(int j=1;j<=rem;j++){
                ans+=j+mod;
            }
        return ans;
    }
}
*/
