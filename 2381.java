class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shiftDiff = new int[n + 1];
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2] == 1 ? 1 : -1;
            shiftDiff[start] += direction;
            shiftDiff[end + 1] -= direction;
        }
        int cumulativeShift = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < n; i++) {
            cumulativeShift += shiftDiff[i];
            int effectiveShift = ((cumulativeShift % 26) + 26) % 26;
            ch[i] = (char) ('a' + (ch[i] - 'a' + effectiveShift) % 26);
        }

        return new String(ch);
    }
}
