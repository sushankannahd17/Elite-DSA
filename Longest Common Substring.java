import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s1 = sc.nextLine(), s2 = sc.nextLine();
		
		int R = s1.length(), C = s2.length();
		int[][] dp = new int[R + 1][C + 1];
		int res = 0;
		List<Integer> ansLis = new ArrayList<>();
		
		for (int row = 1; row <= R; row++) {
			for (int col = 1; col <= C; col++) {
				if (s1.charAt(row - 1) == s2.charAt(col - 1)) {
					dp[row][col] = dp[row - 1][col - 1] + 1;
					if (res < dp[row][col]) {
						ansLis.clear();
						ansLis.add(row);
						res = dp[row][col];
					} else if (res == dp[row][col]) {
						ansLis.add(row);
					}
				}
			}
		}
		
		for (Integer pos : ansLis) {
			System.out.println(s1.substring(pos - res, pos));
		}
	}
}