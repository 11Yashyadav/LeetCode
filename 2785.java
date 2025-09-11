class Solution {
    public String sortVowels(String s) {
        int idx[] = new int[s.length()];
        char elements[] = new char[s.length()];
        int count = 0;
        char[] letters = s.toCharArray();
        for(int i=0;i<letters.length;i++){
            char c = Character.toLowerCase(letters[i]);
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                idx[count] = i;
                elements[count] = letters[i];
                count++;
            }
        }
        Arrays.sort(elements, 0, count);
        for(int i=0;i<count;i++){
            int j = idx[i];
            letters[j] = elements[i];
        }
        return new String(letters);
    }
}
