class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
        Arrays.sort(edges, (a, b)->(a[2]-b[2]));
        UnionFind uf=new UnionFind(V);
        
        int cost=0;
        for (int[] edge:edges) {
            int src=edge[0], dest=edge[1], wgt=edge[2];
            
            if (uf.find(src)==uf.find(dest)) continue;
            
            uf.join(src, dest);
            cost+=wgt;
        }
        
        return cost;
    }
}

class UnionFind {
    int[] arr;
    
    UnionFind(int N) {
        arr=new int[N];
        for (int i = 0; i < N; i++) arr[i]=i;
    }
    
    public int find(int node) {
        if (arr[node]!=node) {
            arr[node]=find(arr[node]);
        }
        
        return arr[node];
    }
    
    public void join(int lt, int rt) {
        int ltldr=find(lt), rtldr=find(rt);
        
        arr[rtldr]=ltldr;
    }
}