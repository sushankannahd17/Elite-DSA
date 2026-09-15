import java.util.* ;
import java.io.*; 
public class Solution {
	private static final int INF=Integer.MAX_VALUE;

	public static int[] rangeMinimumQuery(int N, int[] arr, int Q, int[][] query) {
		// Write your code here.
		int newN=1;
		while (newN<N) {
			newN<<=1;
		}

		int[] segmentTree=new int[newN+newN];
		Arrays.fill(segmentTree, INF);
		for (int idx=0; idx<N; idx++) {
			segmentTree[idx+newN]=arr[idx];
		}

		for (int idx=newN-1; idx>0; idx--) {
			segmentTree[idx]=Math.min(segmentTree[idx*2], segmentTree[idx*2+1]);
		}
		N=newN;
		int[] res=new int[Q];

		for (int idx=0; idx<Q; idx++) {
			int lt=query[idx][0], rt=query[idx][1];

			res[idx]=find(segmentTree, 1, 0, N-1, lt, rt);
		}

		return res;
	}

	private static int find(int[] arr, int node, int nlt, int nrt, int qlt, int qrt) {
		if (nlt>qrt || nrt<qlt) {
			return INF;
		}

		if (qlt<=nlt && nrt<=qrt) {
			return arr[node];
		}

		int mid=nlt+(nrt-nlt)/2;

		int ltVal=find(arr, node*2, nlt, mid, qlt, qrt);
		int rtVal=find(arr, node*2+1, mid+1, nrt, qlt, qrt);

		return Math.min(ltVal, rtVal);
	}
}