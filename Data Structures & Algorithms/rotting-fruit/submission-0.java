
class Solution {
    class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
    public int orangesRotting(int[][] grid) {
        int visGrid[][] = new int[grid.length][grid[0].length];
        Queue<Pair> rottenOranges = new LinkedList();
        int goodOranges = 0;
        int time =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    rottenOranges.offer(new Pair(i,j));
                }else{
                    if(grid[i][j] == 1){
                    goodOranges++;
                    }
                }
            }
        }
        rottenOranges.offer(new Pair(-1,-1));
        int x[] = {1,0,-1,0};
        int y[] = {0,1,0,-1};
        while(rottenOranges.size()>0){
            Pair currentValue = rottenOranges.poll();
            int currentX = currentValue.getX();
            int currentY = currentValue.getY();
            if (currentX == -1 && currentY == -1) {
    time++;
    if (!rottenOranges.isEmpty()) {
        rottenOranges.offer(new Pair(-1, -1));  
    }
    continue;
}

            System.out.println(currentX+" "+ currentY);
            for(int i=0;i<4;i++){
                int nextX = currentX+ x[i];
                int nextY = currentY+ y[i];
               
                if(isValid(nextX,nextY,grid)){
                    grid[nextX][nextY] = 2;
                    rottenOranges.offer(new Pair(nextX,nextY));
                    System.out.println(nextX+" "+ nextY +" l");
                    goodOranges--;
                }
            }
         
        }
 return goodOranges == 0 ? Math.max(time - 1, 0) : -1;     
    }

    private boolean isValid(int x,int y,int[][] grid){
        return (x>=0  && x<grid.length&&  y>=0 && y<grid[0].length && grid[x][y] ==1);
    }

   
}
