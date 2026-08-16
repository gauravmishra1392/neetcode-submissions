class UnionFind{
    int parent[];
    int rank[];
    UnionFind(int size){
        parent = new int[size+1];
        rank = new int[size+1];
        for(int i=0;i<=size;i++){
            parent[i] = i;
        }
    }

    void union(int a, int b){
        int parenta = find(a);
        int parentb = find(b);
        if(parenta != parentb){
        if(rank[parenta] > rank[parentb]){
            parent[parentb] = parent[parenta];
        }else if(rank[parenta] < rank[parentb]){
            parent[parenta] = parent[parentb];
        }else{
            parent[parenta] = parent[parentb];
            rank[parentb]++;
        }
        }
    }

    int find(int a){
        if(a!= parent[a]){
            parent[a] =find(parent[a]);
        }
        return parent[a];
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
    int n = edges.length;
    UnionFind uf = new UnionFind(n);
        for(int edge[]: edges){
            int a =  uf.find(edge[0]);
            int b = uf.find(edge[1]);

            if(a == b){
                return edge;
            }

            uf.union(a,b);
        }
        return new int[0];
    }
}
