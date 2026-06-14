import java.util.*;

public class Main {
	private static int MOD = 1000_000_007;
	static int N, M, bonus;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); M = sc.nextInt(); bonus = sc.nextInt();
		int[][] ns = new int[N][2], ms = new int[M][2];
		
		for (int i = 0; i < N; i++) {
			ns[i] = new int[] {sc.nextInt(), sc.nextInt()};
		}
		
		for (int i = 0; i < M; i++) {
			ms[i] = new int[] {sc.nextInt(), sc.nextInt()};
		}
		
		int[][] dp = new int[N + 1][M + 1];
		for (int i = 0; i <= N; i++) Arrays.fill(dp[i], MOD);
		int maxpts = Math.max(0, stitch(dp, ns, ms, 0, 0, 2000));
		System.out.println(maxpts);
	}
	
	private static int stitch(int[][] dp, int[][] ns, int[][] ms, int nsi, int msi, int ptxt) {
		if(nsi >= N && msi >= M) return 0;
		
		if(dp[nsi][msi] != MOD){
			return dp[nsi][msi];
		}
		int maxpts = 0;
		if(nsi < N){
			int nextpts = stitch(dp, ns, ms, nsi + 1, msi, ns[nsi][0]);
			int currpts = ns[nsi][1];
			if(ptxt == ns[nsi][0]) currpts += bonus;
			if(nextpts > 0) currpts += nextpts;
			maxpts = Math.max(maxpts,currpts);
		}
		if(msi<M){
			int nextpts = stitch(dp, ns, ms, nsi, msi + 1, ms[msi][0]);
			int currpts = ms[msi][1];
			if(ptxt == ms[msi][0]) currpts += bonus;
			if(nextpts > 0) currpts += nextpts;
			maxpts = Math.max(maxpts,currpts);
		}
		dp[nsi][msi] = maxpts;
		return maxpts;
	}
}