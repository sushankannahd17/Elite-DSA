import java.util.*;
import java.io.*;
public class Main {    
	public static void main(String[] args) throws IOException {
		FastScanner sc=new FastScanner();
		// PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int N=sc.nextInt(), Q=sc.nextInt();
		int newN=1;
		while (newN<N) {
			newN=newN<<1;
		}
		
		long[] segmentTree=new long[newN*2];
		for (int idx=newN; idx<newN+N; idx++) {
			segmentTree[idx]=sc.nextLong();
		}
		for (int idx=newN-1; idx>=1; idx--) {
			segmentTree[idx]=segmentTree[idx+idx]+segmentTree[idx+idx+1];
		}
		N=newN;
		StringBuilder sb=new StringBuilder();
		while (Q-->0) {
			int query=sc.nextInt();
			if (query==1) {
				int pos=sc.nextInt();
				long val=sc.nextLong();
				update(segmentTree, 1, 1, N, pos, pos, val);
			} else if (query==2) {
				int lt=sc.nextInt(), rt=sc.nextInt();
				sb.append(find(segmentTree, 1, 1, N, lt, rt)).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	private static long find(long[] seg, int node, int nl, int nr, int ql, int qr) {
		if (nl>qr || nr<ql) {
			return 0L;
		}
		
		if (nl>=ql && nr<=qr) {
			return seg[node];
		}
		
		int mid=nl+(nr-nl)/2;
		long ltv=find(seg, node*2, nl, mid, ql, qr);
		long rtv=find(seg, node*2+1, mid+1, nr, ql, qr);
		return ltv+rtv;
	}
	
	private static void update(long[] seg, int node, int nl, int nr, int ql, int qr, long val) {
		if (nl>qr || nr<ql) {
			return;
		}
		
		if (nl>=ql && nr<=qr) {
			seg[node]=val;
			return;
		}
		
		int mid=nl+(nr-nl)/2;
		update(seg, node*2, nl, mid, ql, qr, val);
		update(seg, node*2+1, mid+1, nr, ql, qr, val);
		seg[node]=seg[node*2]+seg[node*2+1];
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