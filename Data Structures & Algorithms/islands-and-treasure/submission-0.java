class Solution {
    class Pair {
        int x;
        int y;
        int dist;
        Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
        int getKey() { return x; }
        int getValue() { return y; }
        int getDist() { return dist; }
    }

    public void islandsAndTreasure(int[][] grid) {

        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new Pair(i, j, 0));
                }
            }
        }

        int x[] = {0, 0, -1, 1};
        int y[] = {1, -1, 0, 0};

        while (queue.size() > 0) {
            Pair current = queue.poll();
            int cx = current.getKey();
            int cy = current.getValue();
            int dist = current.getDist();

            for (int i = 0; i < 4; i++) {
                int nextx = cx + x[i];
                int nexty = cy + y[i];

                // check boundaries and valid land
                if (nextx < 0 || nexty < 0 || nextx >= grid.length || nexty >= grid[0].length || grid[nextx][nexty] != 2147483647)
                    continue;

                // update distance
                grid[nextx][nexty] = dist + 1;
                queue.offer(new Pair(nextx, nexty, dist + 1));
            }
        }
    }

}