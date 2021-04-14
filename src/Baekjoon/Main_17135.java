package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 17135. 캐슬 디펜스
public class Main_17135 {
	static int N, M, D, ans, map[][];
	static int[][] dxdy = {{0, -1}, {-1, 0}, {0, 1}};
	static int[] our = new int[3];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		combi(0, 0);
		System.out.println(ans);
	}
	
	static void combi(int idx, int start) {
		if(idx == 3) {
			ans = Math.max(ans, shoot());
			return;
		}
		for (int i = start; i < M; i++) {
			our[idx] = i;
			combi(idx+1, i+1);
		}
	}
	
	static int shoot() {
		int[][] tmap = new int[N+1][M];
		for (int i = 0; i < N+1; i++)
			System.arraycopy(map[i], 0, tmap[i], 0, M);
		for (int o : our)	tmap[N][o] = 2;

		int nx, ny, cnt=0;
		while(true) {
			LinkedList <int[]> kill = new LinkedList<>();
			for (int i = 0; i < M; i++) {
				if(tmap[N][i] != 2)	continue;
				boolean[][] visit = new boolean[N+1][M];
				Queue<int[]> q = new LinkedList<>();
				q.offer(new int[] {N, i, 0});
				
				top:
				while(!q.isEmpty()) {
					int[] no = q.poll();
					if(no[2]+1 > D) break;

					for (int j = 0; j < 3; j++) {
						nx = no[0] + dxdy[j][0];
						ny = no[1] + dxdy[j][1];
						if(nx<0 || ny<0 || ny>=M)	continue;
							
						if(!visit[nx][ny] && tmap[nx][ny] == 0) {
							q.offer(new int[] {nx, ny, no[2]+1});
							visit[nx][ny] = true;
						} else if(tmap[nx][ny] == 1) {
							kill.add(new int[] {nx, ny, no[2]+1});
							break top;
						}
					}
				}
			}
			for (int[] k : kill) {
				if(tmap[k[0]][k[1]] == 1) {
					tmap[k[0]][k[1]] = 0;
					cnt++;
				}
			}
			
			boolean again = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(tmap[i][j] == 1)	again = true;
				}
			}
			if(!again)	break;
			
			for (int i = N-2; i >= 0; i--)
				System.arraycopy(tmap[i], 0, tmap[i+1], 0, M);
			for (int i = 0; i < M; i++)
				tmap[0][i] = 0;
		}
		return cnt;
	}
}
