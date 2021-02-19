package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3234. 준환이의 양팔저울
public class Solution_3234 {
	static int N, ans, sum;
	static int[] W;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			W = new int[N];
			st = new StringTokenizer(br.readLine());
			sum = 0;
			for (int i = 0; i < N; i++) {
				W[i] = Integer.parseInt(st.nextToken());
				sum += W[i];
			}
			
			ans = 0;
			check = new boolean[N];
			dfs(0, 0, 0, sum);
			System.out.println("#"+t+" "+ans);
		}
	}
	
	static void dfs(int idx, int sumL, int sumR, int remain) {
		if(sumL >= sumR + remain) {
			int cnt=1;
			for(int i=0;i<N-idx;i++) {
				cnt *= 2;
				cnt *= (i+1);
			}
			ans += cnt;
			return;
		}
		if(idx == N) {
			ans++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(check[i])	continue;
			check[i] = true;
			dfs(idx+1, sumL + W[i], sumR, remain - W[i]);
			if(sumL >= sumR + W[i])
				dfs(idx+1, sumL, sumR + W[i], remain - W[i]);
			check[i] = false;
		}
	
	}
}
