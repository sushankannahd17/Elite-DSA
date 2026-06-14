import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine(), s2 = sc.nextLine();

        int R = s1.length(), C = s2.length();

        int[][] dp = new int[R + 1][C + 1];

        int maxRow = -1, maxCol = -1, max = 0;

        for (int row = 1; row <= R; row++) {
            for (int col = 1; col <= C; col++) {
                if (s1.charAt(row - 1) == s2.charAt(col - 1)) {
                    dp[row][col] = 1 + dp[row - 1][col - 1];
                    if (max < dp[row][col]) {
                        max = dp[row][col];
                        maxRow = row;
                        maxCol = col;
                    }
                }
            }
        }

        System.out.println(max);
        StringBuilder sb = new StringBuilder();

        while (dp[maxRow][maxCol] != 0) {
            sb.append(s2.charAt(maxCol - 1));
            maxCol--;
            maxRow--;
        }

        System.out.println(sb.reverse().toString());
    }
}
