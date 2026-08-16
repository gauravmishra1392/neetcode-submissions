class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == '.'){ continue;}
                String row = "row"+i+board[i][j];
                String col = "col"+j+ board[i][j];
                String box = "box"+(i/3)*3+(j/3)+board[i][j];
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
