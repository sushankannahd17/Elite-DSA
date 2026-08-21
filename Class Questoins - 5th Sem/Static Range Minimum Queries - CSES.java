import java.util.*;
import java.io.*;
public class Main {    
	public static void main(String[] args) throws IOException {
		FastScanner sc=new FastScanner();
		PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		int N=sc.nextInt(), Q=sc.nextInt();
		int newN=1;
		while (newN<N) {
			newN=newN<<1;
		}
		newN*=2;
		int[] segmentTree=new int[newN*2];
		Arrays.fill(segmentTree, Integer.MAX_VALUE);

		for (int i=newN; i<newN+N; i++) {
			segmentTree[i]=sc.nextInt();
		}
		
		for (int i=newN-1; i>=0; i--) {
			segmentTree[i]=Math.min(segmentTree[i*2], segmentTree[i*2+1]);
		}
		N=newN;
		
		while (Q-->0) {
			int lt=sc.nextInt(), rt=sc.nextInt();
			out.println(find(segmentTree, 1, 1, N, lt, rt));
		}
		out.close();
	}
	
	private static int find(int[] seg, int node, int nl, int nr, int ql, int qr) {
		// Out of boundaries
		if (nr<ql || nl>qr) {
			return Integer.MAX_VALUE;
		}
		
		if (nl>=ql && nr<=qr) {
			return seg[node];
		}
		int mid=(nl+nr)/2;
		
		int ltv=find(seg, node*2, nl, mid, ql, qr);
		int rtv=find(seg, node*2+1, mid+1, nr, ql, qr);
		return Math.min(ltv, rtv);
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