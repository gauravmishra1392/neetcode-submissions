class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == '.'){ continue;}
                String row = "row"+i+board[i][j];
                String col = "col"+j+ board[i][j];
                int startRow = i - i % 3;
                int startCol = j - j % 3;
                String box = "box"+startRow+"+"+startCol+board[i][j];
                if(seen.contains(row) || seen.contains(col)
                || seen.contains(box)){
                    return false;
                }
                seen.add(row);
                seen.add(col);
                seen.add(box);
            }
           
        }
         return true;
    }
}
