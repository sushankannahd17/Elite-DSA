class Solution {
    public ArrayList<Long> result;
    private long gcd(long x, long y) {
        if (y==0) {
            return x;
        }
        
        return gcd(y, x%y);
    }
    
    public ArrayList<Long> RangeLCMQuery(int[] arr, int[][] queries) {
        // code here
        result=new ArrayList<>();
        
        int N=arr.length;
        int newN=1;
        while (newN<N) {
            newN<<=1;
        }
        
        long[] segmentTree=new long[newN+newN];
        for (int idx=0; idx<newN+newN; idx++) {
            segmentTree[idx]=1;
        }
        for (int idx=0; idx<N; idx++) {
            segmentTree[idx+newN]=arr[idx];
        }
        
        for (int idx=newN-1; idx>0; idx--) {
            segmentTree[idx]=(segmentTree[idx+idx]*segmentTree[idx+idx+1])/gcd(segmentTree[idx+idx], segmentTree[idx+idx+1]);
        }
        N=newN;
        
        for (int[] query:queries) {
            int q=query[0];
            if (q==1) {
                int idx=query[1], val=query[2];
                
                update(segmentTree, 1, 0, N-1, idx, idx, val);
            } else if (q==2) {
                int lt=query[1], rt=query[2];
                
                result.add(find(segmentTree, 1, 0, N-1, lt, rt));
            }
        }
        
        return result;
    }
    
    private long find(long[] arr, int node, int nlt, int nrt, int qlt, int qrt) {
        if (nrt<qlt || qrt<nlt) {
            return 1;
        }
        
        if (qlt<=nlt && nrt<=qrt) {
            return arr[node];
        }
        
        int mid=nlt+(nrt-nlt)/2;
        long ltVal=find(arr, node*2, nlt, mid, qlt, qrt), rtVal=find(arr, node*2+1, mid+1, nrt, qlt, qrt);
        
        return (ltVal*rtVal)/gcd(ltVal, rtVal);
    }
    
    private void update(long[] arr, int node, int nlt, int nrt, int qlt, int qrt, int val) {
        if (nlt>qrt || nrt<qlt) {
            return;
        }
        
        if (qlt<=nlt && nrt<=qrt) {
            arr[node]=val;
            return;
        }
        
        int mid=nlt+(nrt-nlt)/2;
        update(arr, node*2, nlt, mid, qlt, qrt, val); update(arr, node*2+1, mid+1, nrt, qlt, qrt, val);
        
        arr[node]=(arr[node+node]*arr[node+node+1])/gcd(arr[node+node], arr[node+node+1]);
    }
}