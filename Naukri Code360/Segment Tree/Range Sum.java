 
public class Solution {
	public static int[] rangeSum(int[] arr, int[][] queries) {		
	 	// Write your code here
		int N=arr.length;

		int newN=1;
		while (newN<N) newN<<=1;

		int[] segmentTree=new int[newN+newN];
		for (int idx=0; idx<N; idx++) {
			segmentTree[newN+idx]=arr[idx];
		}

		for (int idx=newN-1; idx>0; idx--) {
			segmentTree[idx]=segmentTree[idx*2]+segmentTree[idx*2+1];
		}

		N=newN;
		int[] ans=new int[queries.length];
		int idx=0;
		for (int[] query:queries) {
			int lt=query[0], rt=query[1];

			ans[idx]=find(segmentTree, 1, 1, N, lt, rt);
			idx++;
		}

		return ans;
	}

	private static int find(int[] arr, int node, int nlt, int nrt, int qlt, int qrt) {
		if (nrt<qlt || nlt>qrt) {
			return 0;
		}

		if (qlt<=nlt && nrt<=qrt) return arr[node];

		int mid=nlt+(nrt-nlt)/2;
		return find(arr, node*2, nlt, mid, qlt, qrt)+find(arr, node*2+1, mid+1, nrt, qlt, qrt);
	}
}