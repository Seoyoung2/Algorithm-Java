package SWEA.D3;

import java.util.Scanner;

// 5215. 햄버거 다이어트
public class Solution_5215 {
	static int N, L, ans;
	static int[][] burger;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			N = sc.nextInt();
			L = sc.nextInt();
			
			burger = new int[N][2];
			for (int i = 0; i < N; i++) {
				burger[i][0] = sc.nextInt();
				burger[i][1] = sc.nextInt();
			}
			
			ans = 0;
			solve(0, 0, 0);
			System.out.println("#"+t+" "+ans);
		}
	}
	static void solve(int idx, int score, int cal) {
		if(cal > L) return;
		if(idx == N) {
			ans = Math.max(ans, score);
			return;
		}
		solve(idx+1, score, cal);
		solve(idx+1, score+burger[idx][0], cal+burger[idx][1]);
	}
}
