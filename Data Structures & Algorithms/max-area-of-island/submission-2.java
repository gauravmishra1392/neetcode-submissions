class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        Integer no =0;

        int visited[][]= new int[grid.length][grid[0].length];
        int max = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1 && visited[i][j]!=1){
                   max = Math.max(max,dfs(grid,i,j,visited));
                }
            }
        }
        return max;
    }
    boolean notValid(int x,int y,int grid[][]){
        return !(x>=0 && x<grid.length && y>=0 && y<grid[0].length);
    }
    int dfs(int grid[][],int x,int y, int visited[][]){
        if(notValid(x,y,grid)){
            return 0;
        }
  
        if(visited[x][y] == 1 ){
            return 0;
        }
        if(grid[x][y] == 0 ){
            return 0;
        }
        
        visited[x][y] = 1;

        int area = 1;

        area = area + dfs(grid,x+1,y,visited);
        area = area + dfs(grid,x,y+1,visited);
        area = area + dfs(grid,x-1,y,visited);
        area = area + dfs(grid,x,y-1,visited);

        return area;
    }

}
