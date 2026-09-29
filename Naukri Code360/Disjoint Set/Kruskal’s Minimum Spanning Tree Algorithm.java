import java.util.*;

class DisjointSet {
    int[] arr;
    DisjointSet(int N) {
        this.arr=new int[N+1];
        for (int i=0; i<=N; i++) {
            this.arr[i]=i;
        }
    }

    public int find(int idx) {
        if (arr[idx]!=idx) {
            arr[idx]=find(arr[idx]);
        }

        return arr[idx];
    }

    public boolean isConnected(int lt, int rt) {return find(lt)==find(rt);}

    public void join(int lt, int rt) {
        if (!isConnected(lt, rt)) {
            arr[find(rt)]=find(lt);
        }
    }
}

public class Solution {
    public static int kruskalMST(int N,int [][]edges) {
        //Write your code here
        Arrays.sort(edges, (a, b)->Integer.compare(a[2], b[2]));
        int sum=0;
        DisjointSet dsu=new DisjointSet(N);

        for (int[] edge:edges) {
            int src=edge[0], dest=edge[1], wgt=edge[2];

            if (!dsu.isConnected(src, dest)) {
                dsu.join(src, dest);
                sum+=wgt;
            }
        }

        return sum;
    }
}