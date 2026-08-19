import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s1=sc.nextLine(), s2=sc.nextLine();
		int R=s1.length(), C=s2.length();
		
		int[][] dp=new int[R+1][C+1];
		int max=0;
		for (int row=1; row<=R; row++) {
			for (int col=1; col<=C; col++) {
				if (s1.charAt(row-1)==s2.charAt(col-1)) {
					dp[row][col]=dp[row-1][col-1]+1;
					max=Math.max(max, dp[row][col]);
				}
			}
		}
		
		System.out.println((R+C)-(2*max));
	}
}