class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        
        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Build the graph (undirected)
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int components = 0;

        // DFS for each unvisited node
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                dfs(i, visited, adjList);
            }
        }

        return components;
    }

    private void dfs(int node, boolean[] visited, List<List<Integer>> adjList) {
        visited[node] = true;
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adjList);
            }
        }
    }
}
