class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        List<Integer> lst = new ArrayList();
        for(int i=0;i<numCourses ;i++){
            if(!dfs(adjList,visited,i,lst)){
                return new int[0];
            }
        }
        System.out.println(lst+"qq");
        int arr[]=new int[lst.size()];
        for(int i=0;i<lst.size();i++){
            arr[i]=lst.get(i);
        }
        return arr;
    }
    boolean dfs(List<List<Integer>> adj,int[] vis,int n,List<Integer> lst){
        if(vis[n] == 2){
            return true;
        }
        if(vis[n] == 1){
            return false;
        }
        vis[n]=1;
        for(int li:adj.get(n)){
            if(!dfs(adj,vis,li,lst)){
                return false;
            }
        }
        vis[n] =2;   
        lst.add(n);
        System.out.println(n);
        return true;
    }
}
