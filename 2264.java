class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
       int max =-1;
        boolean is = false;
        for(int i =0;i<n-2;i++){
            if(num.charAt(i)==num.charAt(i+1) && num.charAt(i)==num.charAt(i+2)){
                if(num.charAt(i)-'0'>= max){
                    max = num.charAt(i)-'0';
                    is=true;
                    i+=2;
                }
            }
        }
        if(!is) return "";
        if(max==0) return "000";
        return String.valueOf(max*100+max*10+max);
    }
}
