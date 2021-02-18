package SWEA.D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1247. [S/W 문제해결 응용] 3일차 - 최적 경로 (BackTracking)
public class Solution_1247 {
	static int[][] dist;
	static int N, ans;
	static boolean[] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[][] pos = new int[N+2][2];
			// company
			pos[0][0] = Integer.parseInt(st.nextToken()); pos[0][1] = Integer.parseInt(st.nextToken());
			// home
			pos[N+1][0] = Integer.parseInt(st.nextToken()); pos[N+1][1] = Integer.parseInt(st.nextToken());
			for (int i = 1; i <= N; i++) {
				pos[i][0] = Integer.parseInt(st.nextToken());
				pos[i][1] = Integer.parseInt(st.nextToken());
			}
			
			dist = new int[N+2][N+2];
			for (int i = 0; i < N+2; i++) {
				for (int j = 0; j < N+2; j++) {
					int tmp = Math.abs(pos[i][0] - pos[j][0]) + Math.abs(pos[i][1] - pos[j][1]); 
					dist[i][j] = dist[j][i] = tmp;
				}
			}
			
			visit = new boolean[N+2];
			ans = Integer.MAX_VALUE;
			dfs(0, 0, 0);
			System.out.println("#"+t+" "+ans);
		}
	
	}

	private static void dfs(int idx, int cnt, int sum) {
		if(sum >= ans)	return;
		if(cnt == N) {
			sum += dist[idx][N+1];
			ans = Math.min(ans, sum);
			return;
		}
		for (int i = 1; i <= N; i++) {
			if(visit[i])	continue;
			visit[i] = true;
			dfs(i, cnt+1, sum+dist[idx][i]);
			visit[i] = false;
		}
	}
}

