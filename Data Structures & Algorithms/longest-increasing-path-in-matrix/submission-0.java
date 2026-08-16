class NumberPar{
    int number;
}
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int max =-1 ;
      int memo[][] = new int[matrix.length][matrix[0].length];
     for(int i=0;i<matrix.length;i++){
        for(int j=0 ;j<matrix[0].length;j++){
            int localMax = findMax(matrix,i,j,matrix.length,matrix[0].length,memo);
            max = Math.max(localMax,max);
        }
     }
     return max;
  }

int findMax(int matrix[][], int i,int j,int x,int y, int memo[][]){
    if(memo[i][j]!=0){
        return memo[i][j];
    }

    int xpath[] = {0,1,0,-1};
    int ypath[] = {1,0,-1,0};


    for(int p=0; p<4;p++){
        int xclone = i + xpath[p];
        int yclone = j + ypath[p];

        if(xclone >= 0 && xclone < x && yclone >=0
         && yclone < y){
            if(matrix[xclone][yclone] > matrix[i][j]){
             memo[i][j] = Math.max(memo[i][j],
             findMax(matrix,xclone,yclone,x,y,memo))  ; 
            }
         }
    }

    memo[i][j]++;
    return memo[i][j];
}
}