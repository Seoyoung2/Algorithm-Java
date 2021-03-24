package Baekjoon;

import java.util.Scanner;

// 2839. 설탕 배달
public class Main_2839 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
//		int cnt = 0;
//		while(N > 0) {
//			if(N % 5 == 0) {
//				cnt += N / 5;
//				break;
//			}
//			N -= 3;
//			if(N < 0) {
//				cnt = -1;
//				break;
//			}
//			cnt++;
//		}
//		System.out.println(cnt);

		int[] dp = new int[5001];
		dp[0] = dp[1] = dp[2] = dp[4] = 5000;
		dp[3] = dp[5] = 1;
		for (int i = 6; i <= N; i++) {
			dp[i] = Math.min(dp[i-3]+1, dp[i-5]+1);
		}
		if(dp[N] >= 5000)	dp[N] = -1;
		System.out.println(dp[N]);
	}
	
}
