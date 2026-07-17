class Solution {
    public ArrayList<Integer> diffArray(int[] arr, int[][] opr) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        int N = arr.length;
        
        int[] delta = new int[N + 2];
        
        for (int[] op : opr) {
            int lt = op[0], rt = op[1], val = op[2];
            
            delta[lt] += val;
            delta[rt + 1] -= val;
        }
        
        for (int i = 1; i <= N + 1; i++) delta[i] += delta[i - 1];
        
        for (int i = 0; i < N; i++) {
            arr[i] += delta[i];
            result.add(arr[i]);
        }
        
        return result;
    }
}