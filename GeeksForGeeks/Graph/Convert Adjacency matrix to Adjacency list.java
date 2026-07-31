class Solution {
    public ArrayList<ArrayList<Integer>> matToAdj(int[][] mat) {
        // code here
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        
        int N=mat.length;
        
        for (int i=0; i<N; i++) {
            res.add(new ArrayList<>());
        }
        
        for (int row=0; row<N; row++) {
            for (int col=0; col<N; col++) {
                if (mat[row][col]==1) {
                    res.get(row).add(col);
                }
            }
        }
        
        return res;
    }
}