class Solution {
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int start) {
        // code here
        List<List<int[]>> graph=new ArrayList<>();
        
        for (int i=0; i<=V; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge:edges) {
            int src=edge[0], dest=edge[1], wgt=edge[2];
            
            graph.get(src).add(new int[] {dest, wgt});
            graph.get(dest).add(new int[] {src, wgt});
        }
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[1]-b[1]));
        int[] dist=new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start]=0;
        pq.offer(new int[] {start, 0});
        
        while (!pq.isEmpty()) {
            int[] popped=pq.poll();
            
            int src=popped[0], wgt=popped[1];
            
            if (dist[src] < wgt) continue;
            
            for (int[] node:graph.get(src)) {
                int dest=node[0], tempWgt=node[1];
                
                int newWgt=dist[src]+tempWgt;
                
                if (newWgt < dist[dest]) {
                    pq.offer(new int[] {dest, newWgt});
                    dist[dest]=newWgt;
                }
            }
        }
        
        ArrayList<Integer> res=new ArrayList<>();
        for (int i=0; i<V; i++) {
            res.add(dist[i]);
        }
        return res;
    }
}