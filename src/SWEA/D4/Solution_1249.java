package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 1249. [S/W 문제해결 응용] 4일차 - 보급로
public class Solution_1249 {
	static int[][] dxdy = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static int N;
	static int[][] map, time;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j) - '0';
				}
			}
			
			time = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(time[i], Integer.MAX_VALUE);
			}
			System.out.printf("#%d %d\n", tc, bfs());
		}
	}

	static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0});
		time[0][0] = 0;
		
		int x, y, nx, ny;
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.poll()[1];
			
			for (int i = 0; i < 4; i++) {
				nx = x + dxdy[i][0];
				ny = y + dxdy[i][1];
				if(nx<0 || nx>=N || ny<0 || ny>=N)	continue;
				if(time[nx][ny] > time[x][y] + map[nx][ny]) {
					time[nx][ny] = time[x][y] + map[nx][ny];
					q.offer(new int[] {nx, ny});
				}
			}
		}
		return time[N-1][N-1];
	}
	
}
