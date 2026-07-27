class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> graph=new ArrayList<>();
        
        for (int i=0; i<V; i++) graph.add(new ArrayList<>());
        
        for (int[] edge:edges) {
            int src=edge[0], dest=edge[1];
            
            graph.get(src).add(dest);
        }
        
        int[] indeg=new int[V];
        for (int i=0; i<V; i++) {
            for (int node:graph.get(i)) {
                indeg[node]++;
            }
        }
        
        Queue<Integer> q=new LinkedList<>();
        for (int i=0; i<V; i++) {
            if (indeg[i]==0) {
                q.offer(i);
            }
        }
        
        while (!q.isEmpty()) {
            int pop=q.poll();
            
            for (int node:graph.get(pop)) {
                indeg[node]--;
                
                if (indeg[node]==0) {
                    q.offer(node);
                }
            }
        }
        
        for (int i=0; i<V; i++) {
            if (indeg[i]!=0) {
                return true;
            }
        }
        
        return false;
    }
}