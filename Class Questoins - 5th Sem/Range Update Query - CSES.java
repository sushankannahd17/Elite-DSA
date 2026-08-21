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
		long[] segmentTree=new long[newN+newN];
		for (int i=newN; i<newN+N; i++) {
			segmentTree[i]=sc.nextLong();
		}
		// for (int i=newN-1; i>0; i--) {
			// segmentTree[i]=segmentTree[i*2]+segmentTree[i*2+1];
		// }
		
		StringBuilder sb=new StringBuilder();
		while (Q-->0) {
			int query=sc.nextInt();
			if (query==1) {
				int lt=sc.nextInt(), rt=sc.nextInt();
				long val=sc.nextLong();
				update(segmentTree, 1, 1, newN, lt, rt, val);
			} else if (query==2) {
				int pos=sc.nextInt();
				sb.append(find(segmentTree, 1, 1, newN, pos, pos)).append("\n");
			}
		}
		out.println(sb.toString());
		out.close();
	}
	
	private static void update(long[] seg, int node, int nlt, int nrt, int qlt, int qrt, long val) {
		if (nrt<qlt || qrt<nlt) {
			return;
		}
		
		if (nlt>=qlt && nrt<=qrt) {
			seg[node]+=val;
			return;
		}
		int mid=(nlt+nrt)/2;
		if (qlt<=mid) update(seg, node*2, nlt, mid, qlt, qrt, val);
		if (qrt>mid) update(seg, node*2+1, mid+1, nrt, qlt, qrt, val);
		//seg[node]=seg[node*2]+seg[node*2+1];
	}
	
	private static long find(long[] seg, int node, int nlt, int nrt, int qlt, int qrt) {
		if (nrt<qlt || nlt>qrt) {
			return 0;
		}
		
		if (nlt>=qlt && nrt<=qrt) {
			return seg[node];
		}
		
		int mid=(nlt+nrt)/2;
		return seg[node]+find(seg, node*2, nlt, mid, qlt, qrt)+find(seg, node*2+1, mid+1, nrt, qlt, qrt);
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