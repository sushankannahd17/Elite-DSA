import java.util.*;
import java.io.*;
public class Main {    
	public static void main(String[] args) throws IOException {
		FastScanner sc=new FastScanner();
		PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringBuilder sb=new StringBuilder();
		
		int N=sc.nextInt(), Q=sc.nextInt();
		int newN=1; 
		
		while (newN<N) {
			newN<<=1;
		}
		
		int[] segmentTree=new int[newN+newN];
		for (int idx=newN; idx<newN+N; idx++) {
			segmentTree[idx]=sc.nextInt();
		}
		
		for (int idx=newN-1; idx>0; idx--) {
			segmentTree[idx]=segmentTree[idx*2]^segmentTree[idx*2+1];
		}
		N=newN;
		
		for (int i=1; i<=Q; i++) {
			int lt=sc.nextInt(), rt=sc.nextInt();
			
			sb.append(find(segmentTree, 1, 1, N, lt, rt)).append("\n");
		}
		
		out.println(sb);
		out.close();
	}
	
	private static int find(int[] arr, int node, int nlt, int nrt, int qlt, int qrt) {
		if (nrt<qlt || nlt>qrt) {
			return 0;
		}
		
		if (qlt<=nlt && nrt<=qrt) {
			return arr[node];
		}
		
		int mid=nlt+(nrt-nlt)/2;
		int ltVal=find(arr, node*2, nlt, mid, qlt, qrt), rtVal=find(arr, node*2+1, mid+1, nrt, qlt, qrt);
		
		return (ltVal^rtVal);
	}
}

class FastScanner {
	BufferedReader br;
	StringTokenizer st;

	public FastScanner() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

	public long nextLong() {
		return Long.parseLong(next());
	}
		
	public float nextFloat() {
		return Float.parseFloat(next());
	}

	public double nextDouble() {
		return Double.parseDouble(next());
	}
}