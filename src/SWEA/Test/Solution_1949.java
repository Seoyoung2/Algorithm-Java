package SWEA.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1949. [모의 SW 역량테스트] 등산로 조성
public class Solution_1949 {
	static int N, K, ans;
	static int map[][];
	static boolean visit[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visit = new boolean[N][N];
			ans = 0;
			
			int high = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					high = Math.max(high, map[i][j]);
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == high)	dfs(i, j, false, 1);
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static int[][] dxdy = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static void dfs(int x, int y, boolean b, int cnt) {
		visit[x][y] = true;
		
		int nx, ny;
		for (int i = 0; i < 4; i++) {
			nx = x + dxdy[i][0];
			ny = y + dxdy[i][1];
			if(nx<0 || nx>=N || ny<0 || ny>=N || visit[nx][ny])	continue;
			if(map[nx][ny] < map[x][y]) {
				dfs(nx, ny, b, cnt+1);
			}else {
				if(!b){
					for (int j = 1; j <= K; j++) {
						if(map[nx][ny]-j < map[x][y]) {
							map[nx][ny] -= j;
							dfs(nx, ny, true, cnt+1);
							map[nx][ny] += j;
						}
					}
				}
			}
		}
		visit[x][y] = false;
		ans = Math.max(ans, cnt);
	}

	
	
}
