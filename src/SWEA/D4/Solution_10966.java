package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 10966. 물놀이를 가자
public class Solution_10966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N, M;
		char[][] map;
		int[][] cnt;
		int[][] dxdy = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			cnt = new int[N][M];
			
			Queue<int[]> q = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = line.charAt(j);
					if(map[i][j] == 'W') {
						q.offer(new int[] {i, j});
						cnt[i][j] = 1;
					}
				}
			}
			int x, y, nx, ny;
			while(!q.isEmpty()) {
				x = q.peek()[0];
				y = q.poll()[1];
				for (int i = 0; i < 4; i++) {
					nx = x + dxdy[i][0];
					ny = y + dxdy[i][1];
					if(nx<0 || nx>=N || ny<0 || ny>=M || cnt[nx][ny] != 0)	continue;
					q.offer(new int[] {nx, ny});
					cnt[nx][ny] = cnt[x][y] + 1;
				}
			}
			
			int ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					ans += cnt[i][j];
				}
			}
			
			System.out.println("#" + tc + " " + (ans-N*M));
		}
	}
	
}
