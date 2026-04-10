// Problem: A. Greg and Array
// Contest: Codeforces - Codeforces Round 179 (Div. 1)
// URL: https://codeforces.com/problemset/problem/295/A
// Memory Limit: 256 MB
// Time Limit: 1500 ms
// 
// Powered by CP Editor (https://cpeditor.org)

import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);

	static void solve() {
 		int N = sc.nextInt(), M = sc.nextInt(), K = sc.nextInt();
 		
 		long[] arr = new long[N + 1];
 		for (int i = 1; i <= N; i++) arr[i] = sc.nextInt();
 		
 		int[][] oQueries = new int[M + 1][3];
 		for (int i = 1; i <= M; i++) {
 			oQueries[i][0] = sc.nextInt();
 			oQueries[i][1] = sc.nextInt();
 			oQueries[i][2] = sc.nextInt();
 		}   	
 		
 		long[] qdp = new long[M + 2], odp = new long[N + 2];
		for (int i = 1; i <= K; i++) {
			int lt = sc.nextInt(), rt = sc.nextInt();
			qdp[lt] += 1;
			qdp[rt + 1] -= 1;
		}
		
		for (int i = 2; i <= M + 1; i++) {
			qdp[i] += qdp[i - 1];
		}
		
		for (int i = 1; i <= M; i++) {
			int lt = oQueries[i][0], rt = oQueries[i][1], val = oQueries[i][2];
			
			odp[lt] += (val * qdp[i]);
			odp[rt + 1] -= (val * qdp[i]);
		} 
		
		for (int i = 2; i <= N + 1; i++) {
			odp[i] += odp[i - 1];
		}		
		
		for (int i = 1; i <= N; i++) arr[i] += odp[i];
		
		for (int i = 1; i <= N; i++) System.out.print(arr[i] + " ");
	}

	public static void main(String[] args) {
	    int tc = 1;
	
	    while (tc-- > 0) solve();
	}
}