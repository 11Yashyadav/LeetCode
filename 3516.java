class Solution {
    public int findClosest(int x, int y, int z) {
        int m1 = Math.abs(x-z);
        int m2 = Math.abs(y-z);
        if(m1 < m2){
            return 1;
        }
        else if (m2< m1){
            return 2;
        }
        else{
            return 0;
        }
    }
}
