class Solution {
    public int minSubarraySum(int[] arr) {
        // code here
        int minSum=arr[0], res=arr[0];
        
        for (int idx=1; idx<arr.length; idx++) {
            res=Math.min(res+arr[idx], arr[idx]);
            minSum=Math.min(minSum, res);
        }
        
        return minSum;
    }
}