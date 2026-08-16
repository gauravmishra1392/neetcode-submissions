class Solution {
    public boolean exist(char[][] board, String word) {
        int v[][] = new int[board.length][board[0].length];
       for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                   if(dfs(board,i,j,0,word,v)){
                      return true;
                   }
                }
            }
       }

       return false; 
    }

    boolean dfs(char[][] board,int x, int y, int start, String word,int[][] v){
        
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length){
            return false;
        }
        
   

        if(v[x][y] == 1){
            return false;
        }

        if (board[x][y] != word.charAt(start)) {
            return false;
        }

        if(start == word.length()-1){
            return true;
        }

        v[x][y] = 1;
        boolean found = dfs(board,x,y+1,start+1,word,v) ||
        dfs(board,x+1,y,start+1,word,v) ||
        dfs(board,x-1,y,start+1,word,v) ||
        dfs(board,x,y-1,start+1,word,v);
        v[x][y] = 0;

        return found;
    }
}
