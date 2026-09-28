import java.util.* ;
import java.io.*; 

public class Solution {
	public static int[] nextGreater(int[] arr, int N) {	
		//Write Your code here
		Stack<Integer> stk=new Stack<>();
		int[] res=new int[N];

		for (int i=N-1; i>=0; i--) {
			while (!stk.isEmpty() && stk.peek()<=arr[i]) {
				stk.pop();
			}
			if (stk.isEmpty()) {
				res[i]=-1;
			} else {
				res[i]=stk.peek();
			}
			stk.push(arr[i]);
		}	

		return res;
	}
}
