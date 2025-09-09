class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] spread = new int[n];
        spread[0] = 1;
        int winEnd = -1;
        int winStart = -1;
        int winSum = 0;
        int mod = 1_000_000_007;
        for(int i=delay; i<n; i++){
            
            if(i>=forget){
                winStart++;
                winSum -= spread[winStart];
                if(winSum<0) winSum += mod;
            }
            
            winEnd++;
            winSum = (winSum + spread[winEnd]) % mod;

            spread[i] = winSum;
        }
        int ans = (winSum + winSum) % mod;
        for(int i=n-delay; i<(n-1); i++){
            ans = (ans + spread[i])%mod;
        }
        return ans;
    }
}
