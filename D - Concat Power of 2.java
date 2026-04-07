// Problem: D - Concat Power of 2
// Contest: AtCoder - AtCoder Beginner Contest 451
// URL: https://atcoder.jp/contests/abc451/tasks/abc451_d
// Memory Limit: 1024 MB
// Time Limit: 2000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

import java.util.*;

public class Main {
	static List<String> pows = new ArrayList<>();
	static List<Integer> gi = new ArrayList<>();
	
	static void dfs(String s) {
		if (s.length() > 0) gi.add(Integer.parseInt(s));
		
		for (String str : pows) {
			if (s.length() + str.length() <= 9) {
				dfs(s + str);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for (long i = 1; i < 1000000000L; i *= 2) pows.add(i + "");
		
		dfs("");
		Set<Integer> set = new HashSet<>(gi);
		gi = new ArrayList<>(set);
		Collections.sort(gi);
		System.out.println(gi.get(N - 1));
	}
}