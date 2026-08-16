// CAT

class Solution {
    public boolean exist(char[][] board, String word) {
        int v[][] = new int[board.length][board[0].length];
        for(int i =0 ;i< board.length; i++){
            for(int j =0 ;j< board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(check(board,i,j,0,v,word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean check(char[][] board,int x,int y, int pos,int v[][], String word){
        if(x<0 || x>=board.length || y<0 || y>= board[0].length){
            return false;        
        }

        if(v[x][y] == 1){
            return false;
        }

        if(board[x][y]!=word.charAt(pos)){
            return false;
        }

        if(pos == word.length()-1){
            return true;
        }
        v[x][y]= 1;
        boolean found = false;
        found = found || check(board,x+1,y,pos+1,v,word);
        found = found || check(board,x,y+1,pos+1,v,word);
        found = found || check(board,x-1,y,pos+1,v,word);
        found = found || check(board,x,y-1,pos+1,v,word);
        v[x][y]= 0;
        return found;
    }
}
