class Solution {
    public int numberOfPairs(int[][] points) {
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                if ((x1 >= x2 && y2 >= y1) || (x2 >= x1 && y1 >= y2)) {
                    boolean check = true;
                    for (int k = 0; k < points.length; k++) {
                        if (k != i && k != j) {
                            int x3 = points[k][0];
                            int y3 = points[k][1];
                            if (x3 >= Math.min(x1, x2) && x3 <= Math.max(x1, x2) &&
                                    y3 >= Math.min(y1, y2) && y3 <= Math.max(y1, y2)) {
                                check = false;
                                break;
                            }
                        }
                    }
                    if (check) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
