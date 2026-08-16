class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList();
        
        for(int i=0;i<numCourses;i++){
           adjList.add(new ArrayList());
        }
        
        for(int i=0;i<prerequisites.length;i++){
            adjList
            .get(prerequisites[i][0])
            .add(prerequisites[i][1]);
        }
        int visited[] = new int[numCourses];

        for(int i=0;i<adjList.size() ;i++){
            List<Integer> list = adjList.get(i);
            for(int li:list){
                if(!dfs(adjList,visited,li)){
                    return false;
                }
            }
        }

        return true;
    }

    boolean dfs(List<List<Integer>> adj,int[] vis,int n){
        if(vis[n] == 2){
            return true;
        }
        if(vis[n] == 1){
            return false;
        }
        vis[n]=1;
        for(int li:adj.get(n)){
            if(!dfs(adj,vis,li)){
                return false;
            }
        }
        vis[n] =2;   
    return true;
    }
}
