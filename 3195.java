class Solution {
    public int minimumArea(int[][] grid) {
        int n =grid.length;
        int m = grid[0].length;
        boolean fr=false,sr=false;
        boolean fc=false,sc=false;
        // 1st col and lst col
        // 1st row and last row
        int frow=Integer.MAX_VALUE, fcol=Integer.MAX_VALUE;
        int lrow=-1, lcol=-1;
       for(int i =0;i<n;i++){// row
        for(int j =0;j<m;j++){ // col
        if(grid[i][j]==1){
            frow = Math.min(frow,i);
            lrow=Math.max(lrow,i);
            fcol = Math.min(fcol,j);
            lcol=Math.max(lcol,j);
        }
        }
       }
      
       int len = lcol-fcol+1;
       int bre= lrow-frow+1;
      
       return len*bre;
        
    }
}
