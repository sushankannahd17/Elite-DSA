import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) arr[i] = sc.nextInt();
		
		int Q = sc.nextInt();
		
		int[] dp = new int[N + 2];
		for (int i = 1; i <= Q; i++) {
			int lt = sc.nextInt(), rt = sc.nextInt(), val = sc.nextInt();
			
			dp[lt] += val;
			dp[rt + 1] -= val;
		}
		
		for (int i = 2; i <= N + 1; i++) {
			dp[i] += dp[i - 1];
		}
		
		for (int i = 1; i <= N; i++) arr[i] += dp[i];
		
		for (int i = 1; i <= N; i++) System.out.print(arr[i] + " ");
	}
}