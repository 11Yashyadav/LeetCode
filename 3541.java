class Solution {
    public int maxFreqSum(String s) {
        int n = s.length();
        char arr[]= s.toCharArray();
        int fre[]= new int[26];
        for(char c: arr){
            fre[c-'a']++;
        }
        // for vowel
        int vow =Math.max(fre['a'-'a'],Math.max(fre['e'-'a'],Math.max(fre['i'-'a'],Math.max(fre['o'-'a'],fre['u'-'a']))));
        fre[0]=0;
        fre['e'-'a']=0;
        fre['i'-'a']=0;
        fre['o'-'a']=0;
        fre['u'-'a']=0;
        int cos =0;
       for(int i =1;i<26;i++){
        cos=Math.max(cos,fre[i]);
       }
       return vow+cos;
    }
}
