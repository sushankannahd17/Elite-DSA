import java.util.*;
import java.io.*;
public class Main {    
	public static void main(String[] args) throws IOException {
		FastScanner sc=new FastScanner();
		PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		int R=sc.nextInt(), C=sc.nextInt();
		char[][] grid=new char[R][C];
		boolean[][] visited=new boolean[R][C];
		int[][] direction=new int[R][C];
		Queue<int[]> queue=new LinkedList<>();
		
		for (int row=0; row<R; row++) {
			String s=sc.next();
			for (int col=0; col<C; col++) {
				grid[row][col]=s.charAt(col);
				if (grid[row][col]=='A') {
					queue.offer(new int[] {row, col});
					visited[row][col]=true;
				}
			}
		}
		
		int[][] OFFSETS={{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
		char[] DIRECTIONS={'U', 'L', 'D', 'R'};
		int[] finalDir={-1, -1};
		
		while (!queue.isEmpty()) {
			int[] popped=queue.poll();
			int row=popped[0], col=popped[1];
			if (grid[row][col]=='B') {
				finalDir=new int[] {row, col};
				break;
			}
			
			for (int i=0; i<OFFSETS.length; i++) {
				int aRow=row+OFFSETS[i][0], aCol=col+OFFSETS[i][1];
				
				if (0<=aRow && aRow<R && 0<=aCol && aCol<C && grid[aRow][aCol]!='#' && !visited[aRow][aCol]) {
					visited[aRow][aCol]=true;
					direction[aRow][aCol]=i;
					queue.offer(new int[] {aRow, aCol});
				}
			}
		}
		
		if (finalDir[0]==-1) {
			System.out.println("NO");
			return;
		}
		
		int ctr=0, row=finalDir[0], col=finalDir[1];
		StringBuilder sb=new StringBuilder();
		while (grid[row][col]!='A') {
			int idx=direction[row][col];
			sb.append(DIRECTIONS[idx]);
			ctr++;
			row-=OFFSETS[idx][0]; col-=OFFSETS[idx][1];
		}
		sb.reverse();
		
		System.out.println("YES");
		System.out.println(ctr);
		System.out.println(sb.toString());
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