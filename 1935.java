class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] arr = text.split(" ");
       
        int ans =0;
        for(int i =0;i<arr.length;i++){
            String curr = arr[i];
            boolean is = false;
            for(int j=0;j<brokenLetters.length();j++){
                char cu = brokenLetters.charAt(j);
                int idx = curr.indexOf(cu);
                if(idx!=-1){
                    is=true;
                }
                if(is) break;
            }
            if(!is)ans++;
        }
        return ans;
    }
}
