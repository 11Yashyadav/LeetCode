class Solution {
    public int minAddToMakeValid(String s) {
       Stack <Character> stk = new Stack<>();
       for(int i =0;i<s.length();i++){
        if(s.charAt(i)==')'){
            if(!stk.isEmpty() && stk.peek() == '('){
                stk.pop();
            }
            else{
                stk.push(s.charAt(i));
            }
            
        }
        else{
            stk.push(s.charAt(i));
        }
       }
       return stk.size();
    }
}
************************************************************ OPTIMIZED APPROACH *********************************************************************
class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        int open = 0;
        int close = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
        }
        return open + close;
    }
}
