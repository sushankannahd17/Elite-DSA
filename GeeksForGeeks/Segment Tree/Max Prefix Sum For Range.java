class Solution {
    public ArrayList<Integer> maxPrefixSumQueries(int[] arr, int[][] queries) {
        // code here
        int N=arr.length;
        
        int newN=1;
        while (newN<N) {
            newN<<=1;
        }
        int[] prefix=new int[N];
        prefix[0]=arr[0];
        for (int i=1; i<N; i++) {
            prefix[i]=prefix[i-1]+arr[i];
        }
        
        int[] segmentTree=new int[newN+newN];
        Arrays.fill(segmentTree, Integer.MIN_VALUE);
        for (int idx=0; idx<N; idx++) {
            segmentTree[idx+newN]=prefix[idx];
        }
        
        for (int idx=newN-1; idx>0; idx--) {
            segmentTree[idx]=Math.max(segmentTree[idx*2],segmentTree[idx*2+1]);
        }
        
        N=newN;
        
        ArrayList<Integer> result=new ArrayList<>();
        for (int[] query:queries) {
            int lt=query[0], rt=query[1];
            int before=(lt==0)?0:prefix[lt-1];
            
            result.add(find(segmentTree, 1, 0, N-1, lt, rt)-before);
        }
        
        return result;
    }
    
    private int find(int[] arr, int node, int nlt, int nrt, int qlt, int qrt) {
        if (nrt<qlt || nlt>qrt) {
            return Integer.MIN_VALUE;
        }
        
        if (qlt<=nlt && nrt<=qrt) {
            return arr[node];
        }
        
        int mid=nlt+(nrt-nlt)/2;
        int ltVal=find(arr, node*2, nlt, mid, qlt, qrt), rtVal=find(arr, node*2+1, mid+1, nrt, qlt, qrt);
        
        return Math.max(ltVal, rtVal);
    }
    
    
}
