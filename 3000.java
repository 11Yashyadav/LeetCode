class Solution {
    public int areaOfMaxDiagonal(int[][] d) {
        int ans =-1;
        double max =0;
        int n  = d.length;
        for(int i =0;i<n;i++){
            int l =d[i][0];
            int b =d[i][1];
            double di = l * l + b * b;
            if(di==max){
                ans= Math.max(ans,l*b);
            }
            if(di > max){
                max= di;
                ans = l*b;
            }
        }
        return ans;
    }
}
