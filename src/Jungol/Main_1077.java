package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1077 : 배낭채우기1
public class Main_1077 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[] weight = new int[N+1];
		int[] cost = new int[N+1];
		int[][] dp = new int[N+1][W+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			cost[i] = Integer.parseInt(st.nextToken());
			
			for (int w = 1; w <= W; w++) {
				dp[i][w] = dp[i-1][w];
				if(w >= weight[i]) {
					int cnt = w/weight[i];
					dp[i][w] = Math.max(dp[i][w], dp[i-1][w-cnt*weight[i]]+cnt*cost[i]);
				}
			}
		}
		System.out.println(dp[N][W]);
	}

}
