class Solution {
    public boolean doesAliceWin(String s) {

        for(int i =0;i<s.length();i++)
        {
            char chr = s.charAt(i);
            if(chr=='a'|| chr=='e'|| chr=='i'|| chr=='o'|| chr=='u')
            {
                return true;
            }
        }
        return false;

    }

}
