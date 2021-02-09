package SWEA.D3;

import java.util.Scanner;

// 9229. 한빈이와 Spot Mart
public class Solution_9229 {
	static int N, M, ans;
	static int[] weight;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			weight = new int[N];
			for (int i = 0; i < N; i++)
				weight[i] = sc.nextInt();
			
			ans = -1;
			solve(0, 0, 0);
			System.out.println("#"+t+" "+ans);
		}
	}
	
	static void solve(int idx, int start, int sum) {
		if(sum > M)	return;
		if(idx == 2) {
			ans = Math.max(ans, sum);
			return;
		}
		for (int i = start; i < N; i++) {
			solve(idx+1, i+1, sum+weight[i]);
		}
	}
}
