class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int totd = 2 * n - 1;
        for (int i = n - 1; i >= 0; i--) {
            ArrayList<Integer> a = new ArrayList<>();
            int curi = i;
            int curj = 0;
            while (curi < n && curj < n) {
                a.add(grid[curi][curj]);
                curi++;
                curj++;
            }
            Collections.sort(a, Collections.reverseOrder());
            curi = i;
            curj = 0;
            int x = 0;
            while (x < a.size()) {
                grid[curi][curj] = a.get(x);
                x++;
                curi++;
                curj++;
            }
        }

        for (int j = 1; j < n; j++) {
            ArrayList<Integer> a = new ArrayList<>();
            int curi = 0;
            int curj = j;
            while (curi < n && curj < n) {
                a.add(grid[curi][curj]);
                curi++;
                curj++;
            }
            Collections.sort(a);
            curi = 0;
            curj = j;
            int x = 0;
            while (x < a.size()) {
                grid[curi][curj] = a.get(x);
                x++;
                curi++;
                curj++;
            }

        }

        return grid;
    }
}
