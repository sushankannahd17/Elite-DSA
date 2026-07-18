class UnionFind {
    int[] arr;
    UnionFind(int N) {
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = i;
    }
    
    public int find(int idx) {
        if (arr[idx] != idx) {
            arr[idx] = find(arr[idx]);
        } 
        
        return arr[idx];
    }
    
    public boolean isConnected(int lt, int rt) {
        return (find(lt) == find(rt));
    }
    
    public void join(int lt, int rt) {
        if (!isConnected(lt, rt)) {
            arr[find(rt)] = find(lt);
        }
    }
}

class Solution {
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        UnionFind uf = new UnionFind(V + 1);
        int cost = 0, count = 0;
        
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        for (int[] edge : edges) {
            if (uf.isConnected(edge[0], edge[1])) {
                continue;
            }
            
            uf.join(edge[0], edge[1]);
            cost += edge[2];
            count++;
            if (count == V) break;
        }
        
        return cost;
    }
}
