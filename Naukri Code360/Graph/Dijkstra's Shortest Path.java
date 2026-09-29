import java.util.*;
public class Solution {
    public static List<Integer> dijkstra(int[][] edges,int V, int E, int SRC){
        // Write your code here.
        List<Integer> result=new ArrayList<>();

        List<List<int[]>> graph=new ArrayList<>();
        for (int idx=0; idx<V; idx++) {
            graph.add(new ArrayList<>());
            result.add(Integer.MAX_VALUE);
        }

        for (int[] edge:edges) {
            int src=edge[0], dest=edge[1], wgt=edge[2];

            graph.get(src).add(new int[] {dest, wgt});
            graph.get(dest).add(new int[] {src, wgt});
        }

        PriorityQueue<int[]> pqueue=new PriorityQueue<>((a, b)->Integer.compare(a[1], b[1]));
        Set<Integer> visited=new HashSet<>();

        pqueue.offer(new int[] {SRC, 0});
        visited.add(SRC);
        result.set(SRC, 0);

        while (!pqueue.isEmpty()) {
            int[] popped=pqueue.poll();

            int src=popped[0], wgt=popped[1];
            if (wgt>result.get(src)) continue;

            for (int[] node:graph.get(src)) {
                int dest=node[0], destWgt=wgt+node[1];

                if (result.get(dest)>destWgt) {
                    pqueue.offer(new int[] {dest, destWgt});
                    result.set(dest, destWgt);
                }
            }
        }

        return result;
    }
}
