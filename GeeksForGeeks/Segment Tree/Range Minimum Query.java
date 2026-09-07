class Solution {
    public ArrayList<Integer> res;
    private final int INF=Integer.MAX_VALUE;
    public ArrayList<Integer> rangeMinQuery(int[] arr, int[][] queries) {
        // code here
        
        res=new ArrayList<>();
        int N=arr.length;
        int newN=1;
        while (newN<N) {
            newN=newN<<1;
        }
        
        int[] segmentTree=new int[newN+newN+1];
        Arrays.fill(segmentTree, INF);
        int curr=0;
        for (int idx=newN; idx<newN+N; idx++) {
            segmentTree[idx]=arr[curr];
            curr++;
        }
        for (int idx=newN-1; idx>=1; idx--) {
            segmentTree[idx]=Math.min(segmentTree[idx*2], segmentTree[idx*2+1]);
        }
        N=newN;
        
        for (int[] query:queries) {
            int lt=query[0], rt=query[1];
            
            res.add(find(segmentTree, 1, 0, N-1, lt, rt));
        }
        
        return res;
    }
    
    private int find(int[] arr, int node, int nlt, int nrt, int qlt, int qrt) {
        if (nlt>qrt || nrt<qlt) {
            return INF;
        }
        
        if (qlt<=nlt && qrt>=nrt) {
            return arr[node];
        }
        
        int mid=nlt+(nrt-nlt)/2;
        return Math.min(find(arr, node*2, nlt, mid, qlt, qrt), find(arr, node*2+1, mid+1, nrt, qlt, qrt));
    }
}