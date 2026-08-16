class Solution {
    static class Pair {
        int node;
        int time;
        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Pair>> adjacencyList = new HashMap<>();
        
        for (int i = 0; i < times.length; i++) {
            int start = times[i][0];
            int end = times[i][1];
            int weight = times[i][2];
            
            adjacencyList
                .computeIfAbsent(start, key -> new LinkedList<>())
                .add(new Pair(end, weight));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
        queue.add(new Pair(k, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int start = current.node;
            int time = current.time;

            for (Pair pair : adjacencyList.getOrDefault(start, Collections.emptyList())) {
                int newTime = time + pair.time;
                if (newTime < dist[pair.node]) {
                    dist[pair.node] = newTime;
                    queue.add(new Pair(pair.node, newTime));
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }

        return max;
    }
}
