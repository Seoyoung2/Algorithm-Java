package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1149. RGB거리 
public class Main_1149 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				if(i == 0) {
					dp[i][j] = Integer.parseInt(st.nextToken());
					continue;
				}

				int min = Integer.MAX_VALUE;
				for (int k = 0; k < 3; k++) {
					if(j == k)	continue;
					min = Math.min(min, dp[i-1][k]);
				}
				dp[i][j] = Integer.parseInt(st.nextToken()) + min;
			}
		}
		
		System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
	}
	
}
