import java.util.*;
public class Solution {
	static int[] ldArr;
	public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int N) {
		//Your code goes here
		Collections.sort(edges, (a,b)->Integer.compare(a.get(2), b.get(2)));
		ldArr=new int[N];
		int sum=0;

		for (int idx=0; idx<N; idx++) {
			ldArr[idx]=idx;
		}

		for (ArrayList<Integer> edge:edges) {
			int lt=edge.get(0), rt=edge.get(1), wgt=edge.get(2);

			if (find(lt)==find(rt)) {
				continue;
			}

			ldArr[find(rt)]=find(lt);
			sum+=wgt;
		}

		return sum;
	}

	private static int find(int node) {
		if (ldArr[node]!=node) {
			ldArr[node]=find(ldArr[node]);
		}

		return ldArr[node];
	}
}