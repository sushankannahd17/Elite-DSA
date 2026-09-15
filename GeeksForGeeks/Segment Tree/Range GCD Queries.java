class Solution {
    private int gcd(int x, int y) {
        if (y==0) {
            return x;
        }
        
        return gcd(y, x%y);
    }
    
    public ArrayList<Integer> processQueries(int[] arr, int[][] queries) {
        // code here
        int N=arr.length;
        int newN=1;
        while (newN<N) {
            newN<<=1;
        }
        
        int segmentTree[]=new int[newN+newN];
        for (int idx=0; idx<N; idx++) {
            segmentTree[newN+idx]=arr[idx];
        }
        for (int idx=newN-1; idx>0; idx--) {
            segmentTree[idx]=gcd(segmentTree[idx*2], segmentTree[idx*2+1]);
        }
        N=newN;
        ArrayList<Integer> result=new ArrayList<>();
        
        for (int[] query:queries) {
            int q=query[0];
            if (q==0) {
                int lt=query[1], rt=query[2];
                
                result.add(find(segmentTree, 1, 0, N-1, lt, rt));
            } else if (q==1) {
                int idx=query[1], val=query[2];
                update(segmentTree, 1, 0, N-1, idx, idx, val);
            }
        }
        
        return result;
    }
    
    private int find(int[] arr, int node, int nlt, int nrt, int qlt, int qrt) {
        if (nrt<qlt || nlt>qrt) {
            return 0;
        }
        
        if (qlt<=nlt && nrt<=qrt) {
            return arr[node];
        }
        
        int mid=nlt+(nrt-nlt)/2;
        int ltVal=find(arr, node*2, nlt, mid, qlt, qrt), rtVal=find(arr, node*2+1, mid+1, nrt, qlt, qrt);
        
        return gcd(ltVal, rtVal);
    }
    
    private void update(int[] arr, int node, int nlt, int nrt, int qlt, int qrt, int val) {
        if (nrt<qlt || qrt<nlt) {
            return;
        }
        
        if (qlt<=nlt && nrt<=qrt) {
            arr[node]=val;
            return;
        }
        
        int mid=nlt+(nrt-nlt)/2;
        update(arr, node*2, nlt, mid, qlt, qrt, val); update(arr, node*2+1, mid+1, nrt, qlt, qrt, val);
        arr[node]=gcd(arr[node*2], arr[node*2+1]);
    }
}