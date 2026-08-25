import java.util.*;
import java.io.*;
public class Main {    
	static final long INF=Long.MAX_VALUE;

	private static void solve() {
		int N=sc.nextInt(), Q=sc.nextInt();
		
		int newN=1;
		while (newN<N) newN*=2;
		
		long[] segmentTree=new long[newN*2];
		Arrays.fill(segmentTree, INF);
		for (int idx=newN; idx<newN+N; idx++) {
			segmentTree[idx]=sc.nextLong();
		} 
		
		for (int idx=newN-1; idx>=0; idx--) {
			segmentTree[idx]=Math.min(segmentTree[idx*2], segmentTree[idx*2+1]);
		}
		N=newN;
		
		StringBuilder sb=new StringBuilder();
		while (Q-->0) {
			int query=sc.nextInt();
			if (query==1) {
				int pos=sc.nextInt(); long val=sc.nextLong();
				update(segmentTree, 1, 1, N, pos, pos, val);
			}
			else if (query==2) {
				int lt=sc.nextInt(), rt=sc.nextInt();
				sb.append(find(segmentTree, 1, 1, N, lt, rt)).append("\n");	
			}
		}
		out.println(sb.toString());
	}
	
	private static long find(long[] segmentTree, int node, int nlt, int nrt, int qlt, int qrt) {
		if (nlt>qrt || nrt<qlt) {
			return INF;
		}
		
		if (nlt>=qlt && nrt<=qrt) {
			return segmentTree[node];
		}
		
		int mid=nlt+(nrt-nlt)/2;
		long ltAns=find(segmentTree, node*2, nlt, mid, qlt, qrt);
		long rtAns=find(segmentTree, node*2+1, mid+1, nrt, qlt, qrt);
		return Math.min(ltAns, rtAns);
	}
	
	private static void update(long[] segmentTree, int node, int nlt, int nrt, int qlt, int qrt, long val) {
		if (nlt>qrt || nrt<qlt) {
			return;
		}
		
		if (nlt>=qlt && nrt<=qrt) {
			segmentTree[node]=val;
			return;
		}
		
		int mid=nlt+(nrt-nlt)/2;
		update(segmentTree, node*2, nlt, mid, qlt, qrt, val);
		update(segmentTree, node*2+1, mid+1, nrt, qlt, qrt, val);
		segmentTree[node]=Math.min(segmentTree[node*2], segmentTree[node*2+1]);
	}
	
	static FastScanner sc=new FastScanner();
	static PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	
	public static void main(String[] args) throws IOException {
		int tc=1;
		while (tc-->0) solve();
		out.close();
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