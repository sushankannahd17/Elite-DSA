import java.util.*;

public class Solution {
    public static int networkDelayTime(int[][] edges, int N, int k) {
        // Write your code here.
        List<List<int[]>> graph=new ArrayList<>();

        for (int i=0; i<=N; i++) graph.add(new ArrayList<>());

        for (int[] edge:edges) {
            int src=edge[0], dest=edge[1], wgt=edge[2];
            graph.get(src).add(new int[] {dest, wgt});
        }

        int[] wgts=new int[N+1];
        Arrays.fill(wgts, Integer.MAX_VALUE);
        PriorityQueue<int[]> pqueue=new PriorityQueue<>((a, b)->Integer.compare(a[1], b[1]));
        pqueue.offer(new int[] {k, 0});
        wgts[k]=0;

        while (!pqueue.isEmpty()) {
            int[] popped=pqueue.poll();

            int src=popped[0], wgt=popped[1];
            if (wgt>wgts[src]) continue;

            for (int[] node:graph.get(src)) {
                int tempWgt=wgt+node[1], dest=node[0];

                if (tempWgt<wgts[dest]) {
                    pqueue.offer(new int[] {dest, tempWgt});
                    wgts[dest]=tempWgt;
                }
            }
        }

        int ans=0;
        for (int i=1; i<=N; i++) {
            if (wgts[i]==Integer.MAX_VALUE) {
                return -1;
            }
            ans=Math.max(ans, wgts[i]);
        }

        return ans;
    }
}