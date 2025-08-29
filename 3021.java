class Solution {
    public long flowerGame(int n, int m) {
        long ans =0;
        int e1=0,e2=0;
        int o1=0,o2=0;
        if(n%2==0){
            e1= n/2;
            o1=n/2;
        }else{
            o1=(n+1)/2;
            e1= o1-1;
        }

        if(m%2==0){
            e2= m/2;
            o2=m/2;
        }else{
            o2=(m+1)/2;
            e2= o2-1;
        }
        ans += (long) o1*e2;
        ans += (long) o2*e1;
        return ans;
    }
}
