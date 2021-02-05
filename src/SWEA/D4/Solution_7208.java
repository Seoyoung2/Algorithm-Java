package SWEA.D4;

import java.util.Scanner;

// 7208. 지도 칠하기
public class Solution_7208 {
	static int n, ans;
	static int[] color;
	static int[] tmp;
	static int[][] graph;
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			n = sc.nextInt();
			color = new int[n];
			for (int i = 0; i < n; i++)
				color[i] = sc.nextInt();
			
			tmp = new int[n];
			graph = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					graph[i][j] = sc.nextInt();
			
			ans = Integer.MAX_VALUE;
			solve(0);
			System.out.println("#"+t+" "+ans);
		}
	}
	
	static void solve(int idx) {
		if(idx == n) {
			if(isColorOK()) {
				int cnt = 0;
				for (int i = 0; i < n; i++)
					if(color[i] != tmp[i]) cnt++;
				ans = Math.min(ans, cnt);
			}
			return;
		}
		for (int i = 1; i <= 4; i++) {
			tmp[idx] = i;
			solve(idx+1);
		}
	}
	static boolean isColorOK() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(graph[i][j] == 1 && tmp[i] == tmp[j])
					return false;
			}
		}
		return true;
	}
}
