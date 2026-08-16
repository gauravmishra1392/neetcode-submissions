class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> queue =
            new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        queue.add(new int[]{0,0});
        int n = points.length;
        int visited[] = new int[n];
        int totalCost = 0;
        int edgesUsed = 0;
    
        while(edgesUsed < n && !queue.isEmpty()){
            int pair[] = queue.poll();
            int cost = pair[0];
            int u = pair[1];

            if(visited[u] == 1){
                continue;
            }

            totalCost = totalCost + cost;
            visited[u] = 1;
            edgesUsed++;
            for(int v = 0;v < n ;v++){
                int dist = Math.abs(points[u][0] - points[v][0]) +
                Math.abs(points[u][1] - points[v][1]);
                if(visited[v] == 0)
                {
                    queue.offer(new int[]{dist,v});
                }
            }
        }
        return totalCost;
    }
}
