class Solution {
    public int[] findRedundantConnection(int[][] edges) {
       int n = edges.length+1;
       int parent[] = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
        }
       for(int[] edge:edges){
            int pq = find(parent,edge[0]);
            int pq1 = find(parent,edge[1]);
            if(pq == pq1){
                return edge;
            }
           parent[pq1] = pq;
       }        
       return new int[0];
    }

    int find(int[] parent,int no){
        if(no!=parent[no]){
           parent[no]= find(parent,parent[no]);
        }
        return parent[no];
    }
}
