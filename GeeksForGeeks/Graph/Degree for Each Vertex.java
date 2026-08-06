class Solution {
    public ArrayList<ArrayList<Integer>> findInOutDegree(int V, int[][] edges) {
        //   code here
        int[] indeg=new int[V], outdeg=new int[V];
        List<List<Integer>> graph=new ArrayList<>();
        for (int i=0; i<V; i++) graph.add(new ArrayList<>());
        
        for (int[] edge:edges) {
            int src=edge[0], dest=edge[1];
            
            graph.get(src).add(dest);
        }
        
        for (int i=0; i<V; i++) {
            for (int node:graph.get(i)) {
                indeg[node]++;
            }
            outdeg[i]=graph.get(i).size();
        }
        
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        for (int i=0; i<V; i++) {
            res.add(new ArrayList<>(Arrays.asList(indeg[i], outdeg[i])));
        }
        
        return res;
    }
}
