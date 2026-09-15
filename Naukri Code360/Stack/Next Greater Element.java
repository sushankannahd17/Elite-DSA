import java.util.*;

public class Solution {
    public static int[] nextGreaterElement(int[] arr, int N) {
        // Write your code here.
        int[] res=new int[N];
        Stack<Integer> stk=new Stack<>();

        for (int idx=N-1; idx>=0; idx--) {
            while (!stk.isEmpty() && stk.peek()<=arr[idx]) {
                stk.pop();
            }

            res[idx]=(stk.isEmpty())?-1:stk.peek();
            stk.push(arr[idx]);
        }

        return res;
    }
}