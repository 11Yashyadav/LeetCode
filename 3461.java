class Solution {
    public boolean hasSameDigits(String s) {
        while(s.length()>2){
            StringBuilder str = new StringBuilder();
            for(int i =1;i<s.length();i++){
                int curr = s.charAt(i)-'0';
                int pre = s.charAt(i-1)-'0';
                str.append((curr+pre)%10);
            }
            s= str.toString();
           
        }
        return (s.charAt(0)== s.charAt(1));
    }
}
