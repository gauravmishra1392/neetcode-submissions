class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int no[] = new int[1];
        int max=0;
        int visited[][]= new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1 && visited[i][j]!=1){
                    dfs(grid,i,j,visited,no);
                }
                if(no[0]>max){
                    max=no[0];
                }
                no[0]=0;
            }
        }
        return max;
    }
    boolean notValid(int x,int y,int grid[][]){
        return !(x>=0 && x<grid.length && y>=0 && y<grid[0].length);
    }
    void dfs(int grid[][],int x,int y, int visited[][],int no[]){
        if(notValid(x,y,grid)){
            return;
        }
  
        if(visited[x][y] == 1 ){
            return;
        }
        if(grid[x][y] == 0 ){
            return;
        }
        int xi[] = {0,1,-1,0};
        int yi[] = {1,0,0,-1};
        visited[x][y] =1;
        no[0]++;
        for(int i=0;i<4;i++){
            int xNext= x+xi[i];
            int yNext= y+yi[i];
            dfs(grid,xNext,yNext,visited,no);
        }

    }

}
