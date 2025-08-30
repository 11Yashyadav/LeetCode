class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rows = new HashSet<>();
        Set<Character> cols = new HashSet<>();
        int index = 0;
        for(int row = 0; row<9; row++){
            for(int col=0; col<9; col++){
                if(board[row][col] != '.'){
                    if(rows.contains(board[row][col])) return false;
                    rows.add(board[row][col]);
                }
                if(board[col][row] != '.'){
                    if(cols.contains(board[col][row])) return false;
                    cols.add(board[col][row]);
                }
            }
            rows.clear();
            cols.clear();
        }
        for (int rowIdx = 0; rowIdx < 9; rowIdx += 3) {
            for (int colIdx = 0; colIdx < 9; colIdx += 3) {
                Set<Character> boxSet = new HashSet<>();
                for (int row = rowIdx; row < rowIdx + 3; row++) {
                    for (int col = colIdx; col < colIdx + 3; col++) {
                        if (board[row][col] != '.') {
                            if (boxSet.contains(board[row][col])) return false;
                            boxSet.add(board[row][col]);
                        }
                    }
                }
            }
        }

        
        return true;
    }
}
