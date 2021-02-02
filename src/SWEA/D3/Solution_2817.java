package SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2817. 부분 수열의 합
public class Solution_2817 {
	static int n, k, cnt;
	static int[] num;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(in.readLine());
			num = new int[n];
			for (int i = 0; i < n; i++)
				num[i] = Integer.parseInt(st.nextToken());
			
			cnt = 0;
			solve(0, 0);
			System.out.println("#" + tc + " " + cnt);
		}
	}
	
	private static void solve(int idx, int sum) {
		if (sum == k) {
			cnt++;
			return;
		}
		else if (sum > k || idx >= n)	return;
		solve(idx+1, sum+num[idx]);
		solve(idx+1, sum);
	}
}
