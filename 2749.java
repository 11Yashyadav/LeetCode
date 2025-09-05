class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
       for(int i = 0; i <64; i++){
        long num =  num1 - (long)num2*i; 
        if(num < i)return -1; 
        if(i<=num && Long.bitCount(num)<=i)return i; 
       }
       return -1; 
    }
}
