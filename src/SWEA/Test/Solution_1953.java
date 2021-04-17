package SWEA.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1953. [모의 SW 역량테스트] 탈주범 검거
public class Solution_1953 {
	static int N, M, R, C, L;
	static int map[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			System.out.println("#" + tc + " " + go());
		}
	}

	// 1(상하좌우), 2(상하), 3(좌우), 4(상우), 5(하우), 6(하좌), 7(상좌)
	static int[][] dx = {{}, {-1, 1, 0, 0}, {-1, 1}, {0, 0}, {-1, 0}, {1, 0}, {1, 0}, {-1, 0}};
	static int[][] dy = {{}, {0, 0, -1, 1}, {0, 0}, {-1, 1}, {0, 1}, {0, 1}, {0, -1}, {0, -1}};
	
	static int go() {
		int cnt = 1, time = 1;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {R, C, map[R][C]});
		map[R][C] = 0;
		
		int cur[], size, nx, ny;
		while(!q.isEmpty()) {
			if(time++ == L)	break;
			size = 	q.size();
			while(size-- > 0) {
				cur = q.poll();
				for (int d = 0, end = dx[cur[2]].length; d < end; d++) {
					nx = cur[0] + dx[cur[2]][d];
					ny = cur[1] + dy[cur[2]][d];
					if(nx<0 || nx>=N || ny<0 || ny>=M || map[nx][ny] == 0)	continue;
					// 지하도 모양 이어지는지 확인 ..... how? 반대쪽 방향이 있어야햄(상-하,좌-우)
					int next = map[nx][ny];
					for (int e = 0; e < dx[next].length; e++) {
						if(dx[cur[2]][d]+dx[next][e] == 0 && dy[cur[2]][d]+dy[next][e] == 0) {
							cnt++;
							q.offer(new int[] {nx, ny, next});
							map[nx][ny] = 0;
						}
					}
				}
			}
		}
		return cnt;
	}

}
