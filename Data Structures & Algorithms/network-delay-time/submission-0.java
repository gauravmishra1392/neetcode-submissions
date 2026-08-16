//import java.util.*;

class Solution {
    class Pair {
        int node;
        int time;
        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            int start = times[i][0];
            int end = times[i][1];
            int time = times[i][2];
            adjList.get(start).add(new Pair(end, time));
        }

        int[] minTime = new int[n + 1];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.offer(new Pair(k, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int currNode = current.node;
            int currTime = current.time;

            for (Pair neighbor : adjList.get(currNode)) {
                int nextNode = neighbor.node;
                int newTime = currTime + neighbor.time;
                if (newTime < minTime[nextNode]) {
                    minTime[nextNode] = newTime;
                    pq.offer(new Pair(nextNode, newTime));
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (minTime[i] == Integer.MAX_VALUE) return -1;
            result = Math.max(result, minTime[i]);
        }

        return result;
    }
}
