class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        int n =words.length;
        ans.add(words[0]);
        for(int i =1;i<n;i++){
            char [] l = ans.get(ans.size()-1).toCharArray();
            char [] cur = words[i].toCharArray();
            Arrays.sort(l);
            Arrays.sort(cur);
            if(!Arrays.equals(l, cur)){
                ans.add(words[i]);
            }
        }
        return ans;
    }
}
