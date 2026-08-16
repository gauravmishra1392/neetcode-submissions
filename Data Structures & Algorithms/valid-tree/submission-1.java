// cycle when node is visited but not parent
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n-1 != edges.length){
            return false;
        }
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList());
        }  
        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        } 

        int vis[] = new int[n];
     
        if(!dfs(adjList,0,vis,-1)){
          return false;
        } 

        for(int i=0;i<n;i++){
            if(vis[i] == 0){
                return false;
            }
        }
        return true;
    }
    
    boolean dfs(List<List<Integer>> adjList,int node,int vis[],int parent){
       
        if(vis[node] == 1){
            return false;
        }
        vis[node] = 1;
       for(int li:adjList.get(node)){
            if(li != parent && !dfs(adjList,li,vis,node)){
                return false;
            }
        }

        return true;
    }
}
