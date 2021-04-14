package SWEA.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 5656. [모의 SW 역량테스트] 벽돌 깨기
public class Solution_5656 {
	static int N, W, H, ans;
	static int map[][], tmap[][], order[];
	static int[][] dxdy = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}

			// W중에서 N개 (중복 순열)
			ans = Integer.MAX_VALUE;
			order = new int[N];
			permu(0);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void permu(int idx) {
		if(idx == N) {
			ans = Math.min(ans, start());
			return;
		}
		for (int i = 0; i < W; i++) {
			order[idx] = i;
			permu(idx+1);
		}
	}

	static int start() {
		tmap = new int[H][W];
		for (int i = 0; i < H; i++) {
			System.arraycopy(map[i], 0, tmap[i], 0, W);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < H; j++) {
				if(tmap[j][order[i]] > 0) {
					shoot(j, order[i]);
					break;
				}
			}
		}
		
		// 남은 블럭 개수
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(tmap[i][j] > 0)	cnt++;
			}
		}
		return cnt;
	}

	static void shoot(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y, tmap[x][y]});
		tmap[x][y] = 0;
		
		int cur[], nx, ny;
		while(!q.isEmpty()) {
			cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				for (int j = 1; j < cur[2]; j++) {
					nx = cur[0] + j * dxdy[i][0];
					ny = cur[1] + j * dxdy[i][1];
					if(nx<0 || nx>=H || ny<0 || ny>=W || tmap[nx][ny] == 0)	continue;
					q.offer(new int[] {nx, ny, tmap[nx][ny]});
					tmap[nx][ny] = 0;
				}
			}
		}
		
		// 빈공간 채우기
		for (int j = 0; j < W; j++) {
			ArrayList<Integer> tmp = new ArrayList<>(); 
			for (int i = H-1; i >= 0; i--) {
				if(tmap[i][j] > 0) {
					tmp.add(tmap[i][j]);
					tmap[i][j] = 0;
				}
			}
			int idx = H-1;
			for (Integer t : tmp) {
				tmap[idx--][j] = t;
			}
		}
	}

	
}
