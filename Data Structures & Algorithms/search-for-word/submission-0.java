class Solution {
    public boolean exist(char[][] board, String word) {
        int len = 0;
        int vis[][] = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,i,j,word,len,vis)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isNotValid(char board[][],int row,int col,String word,int vis[][],int len){
        if(row >= board.length || row< 0 || col <0 || col >= board[0].length || word.charAt(len) != board[row][col] || vis[row][col] == 1){
            return true;
        }
        return false;
    }

    boolean dfs(char board[][],int row,int col,String word,int len,int vis[][]){
        if(len == word.length()){
            return true;
        }

        int x[] = {-1,1,0,0};
        int y[] = {0,0,-1,1};

        if(isNotValid(board,row,col,word,vis,len)){
            return false;
        }

        vis[row][col] = 1;
        for(int i=0;i<4;i++){
            int nextX = row + x[i];
            int nextY = col + y[i];
            if(dfs(board,nextX,nextY,word,len+1,vis)){
                return true;
            }
        }
        vis[row][col] = 0;
        return false;
    }
}