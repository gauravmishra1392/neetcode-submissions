class Solution {
    public int swimInWater(int[][] grid) {
     int n = grid.length;   
    PriorityQueue<int[]> pq = 
    new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    pq.offer(new int[]{grid[0][0],0,0});
    int x[] = {-1,0,1,0};
    int y[] = {0,-1,0,1};
    boolean [][]vis= new boolean[n][n];
    vis[0][0] = true;
    while(pq.size()>0){
        int[] val = pq.poll();
        int time = val[0];
        int cx = val[1];
        int cy = val[2];
        vis[cx][cy] = true;
        if(cx == n-1 &&  cy == n-1){
            return time;
        }
        for(int i=0;i<4;i++){

            int nextx = cx + x[i];
            int nexty = cy + y[i];
            
            if(nextx < 0 || nextx>=n || nexty <0 || nexty>=n || vis[nextx][nexty] == true){
                continue;
            }

            pq.offer(new int[]{Math.max(time, grid[nextx][nexty])
            ,nextx,nexty});
        }

     } 
       return -1;
    }
  
}