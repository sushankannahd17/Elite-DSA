import java.util.*;

public class Solution {
    public static int[] Klargest(int[] a, int k, int n) {
        // Write your code here
        PriorityQueue<Integer> pqueue=new PriorityQueue<>(Collections.reverseOrder());

        for (int num:a) {
            pqueue.offer(num);
        }

        int[] res=new int[k];
        for (int i=k-1; i>=0; i--) {
            res[i]=pqueue.poll();
        }

        return res;
    }
}