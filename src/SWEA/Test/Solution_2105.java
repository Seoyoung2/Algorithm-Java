package SWEA.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


// 2105. [모의 SW 역량테스트] 디저트 카페
public class Solution_2105 {
	static int N, ans, cake[][];
	static boolean[][] visit;
	static Set<Integer> eat;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ans = -1;
			N = Integer.parseInt(br.readLine());
			cake = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cake[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 시작 가능 위치 : cake[0~N-3][1~N-2]
			for (int i = 0; i < N-2; i++) {
				for (int j = 1; j < N-1; j++) {
					visit = new boolean[N][N];
					eat = new HashSet<>();
					
					visit[i][j] = true;
					eat.add(cake[i][j]);
					dfs(i, j, i, j, 0);
					eat.remove(cake[i][j]);
					visit[i][j] = false;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	static int[][] dxdy = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};	// 우하->좌하->좌상->우상 
	static void dfs(int cx, int cy, int sx, int sy, int dir) {
		int nx, ny, now;
		for (int d = dir; d < 4; d++) {
			nx = cx + dxdy[d][0];
			ny = cy + dxdy[d][1];
		
			if(nx==sx && ny==sy && eat.size() >= 4) {
				ans = Math.max(ans, eat.size());
				return;
			}

			if(nx<0 || nx>=N || ny<0 || ny>=N || visit[nx][ny] || eat.contains(cake[nx][ny]))	continue;
			now = cake[nx][ny];

			visit[nx][ny] = true;
			eat.add(now);
			dfs(nx, ny, sx, sy, d);
			eat.remove(now);
			visit[nx][ny] = false;
		}
	}

}
