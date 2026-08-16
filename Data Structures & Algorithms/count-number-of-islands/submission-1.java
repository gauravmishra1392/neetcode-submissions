class Solution {
    public int numIslands(char[][] grid) {
        Integer no =0;
        int visited[][]= new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1' && visited[i][j]!=1){
                    no++;
                    dfs(grid,i,j,visited);
                }
            }
        }
        return Integer.valueOf(no);
    }
    boolean notValid(int x,int y,char grid[][]){
        return !(x>=0 && x<grid.length && y>=0 && y<grid[0].length);
    }
    void dfs(char grid[][],int x,int y, int visited[][]){
        if(notValid(x,y,grid)){
            return;
        }
  
        if(visited[x][y] == 1 ){
            return;
        }
        if(grid[x][y] == '0' ){
            return;
        }
        visited[x][y] = 1;
        dfs(grid,x+1,y,visited);
        dfs(grid,x,y+1,visited);
        dfs(grid,x-1,y,visited);
        dfs(grid,x,y-1,visited);
        
    }

}
