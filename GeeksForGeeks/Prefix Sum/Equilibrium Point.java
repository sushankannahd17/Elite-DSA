class Solution {
    public static int findEquilibrium(int arr[]) {
        // code here
        int N=arr.length;
        int[] lSum=new int[N+1];
        for (int i=1; i<=N; i++) {
            lSum[i]=lSum[i-1]+arr[i-1];
        }
        
        int[] rSum=new int[N+1];
        for (int i=N-1; i>=0; i--) {
            rSum[i]=rSum[i+1]+arr[i];
        }
        
        for (int i=0; i<N; i++) {
            if (lSum[i]==rSum[i+1]) return i;
        }
        
        return -1;
    }
}
