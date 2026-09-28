class Solution {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        // code here
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        
        Set<Integer> set=new HashSet<>(), used=new HashSet<>();
        
        for (int num:arr) {
            if (set.contains(-num) && !used.contains(Math.abs(num))) {
                int max=Math.max(num, -num);
                int min=Math.min(num, -num);
                ArrayList<Integer> pair=new ArrayList<>(Arrays.asList(min, max));
                used.add(Math.abs(num));
                res.add(pair);
            }
            set.add(num);
        }
        Collections.sort(res, (a,b)->Integer.compare(a.get(0), b.get(0)));
        return res;
    }
}
