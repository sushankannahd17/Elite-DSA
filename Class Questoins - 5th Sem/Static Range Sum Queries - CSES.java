import java.util.*;
import java.io.*;
public class Main {    
	public static void main(String[] args) throws IOException {
		FastScanner sc=new FastScanner();
		PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int N=sc.nextInt(), Q=sc.nextInt();
		long[] arr=new long[N+1];
		for (int i=1; i<=N; i++) {
			arr[i]=sc.nextLong();
			arr[i]+=arr[i-1];
		}
		
		while (Q-->0) {
			int lt=sc.nextInt(), rt=sc.nextInt();
			out.println(arr[rt]-arr[lt-1]);
		}
		
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