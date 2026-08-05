class Solution {
    public int shortestPath(int V, int[][] edges, int src, int dest) {
        // code here
        List<List<Integer>> graph=new ArrayList<>();
        for (int i=0; i<V; i++) graph.add(new ArrayList<>());
        
        for (int[] edge:edges) {
            int tsrc=edge[0], tdest=edge[1];
            
            graph.get(tsrc).add(tdest);
            graph.get(tdest).add(tsrc);
        }
        
        Set<Integer> set=new HashSet<>();
        Queue<int[]> q=new LinkedList<>();
        
        q.offer(new int[] {src, 0});
        while (!q.isEmpty()) {
            int[] popped=q.poll();
            
            int node=popped[0], steps=popped[1];
            if (node==dest) return steps;
            
            for (Integer adjNode:graph.get(node)) {
                if (!set.contains(adjNode)) {
                    q.offer(new int[] {adjNode, steps+1});
                    set.add(adjNode);
                }
            }
        }
        
        return -1;
    }
}