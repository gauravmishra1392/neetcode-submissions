class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        
        for(int i=0;i<row;i++){
            dfs(board,i,0);
            dfs(board,i,col-1);
        }

        for(int i=0;i<col;i++){
            dfs(board,0,i);
            dfs(board,row-1,i);
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }else{
                    board[i][j] ='X';
                }
            }
        }

    }

    private void dfs(char board[][],int row,int col){
        if(row<0 || row>=board.length ||
        col<0 || col >= board[0].length || board[row][col] == 'X' 
        || board[row][col] == 'T'){
            return;
        }
        board[row][col] = 'T';
        dfs(board,row-1,col);
        dfs(board,row,col-1);
        dfs(board,row+1,col);
        dfs(board,row,col+1);
    }
}
