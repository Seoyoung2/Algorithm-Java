package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2636_good {
	public static void main(String args[]) throws Exception {
		int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		boolean[][] map = new boolean[R][C];
		int cheeze = 0;
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				if (map[i][j] = (line.charAt(j*2) == '1')) {
					cheeze++;
				}
			}
		}

		int cnt = 0;
		boolean[][] v = new boolean[R][C];
		LinkedList<int[]>[] queue = new LinkedList[2];
		queue[0] = new LinkedList<>();
		queue[1] = new LinkedList<>();

		queue[0].offer(new int[] { 0, 0 });
		int curr = 0, next = 1;
		int[] c;
		int nr, nc;
		while (cheeze > 0) {
			while (!queue[curr].isEmpty()) {
				c = queue[curr].poll();
				for (int d = 0; d < 4; d++) {
					nr = c[0] + dir[d][0];
					nc = c[1] + dir[d][1];
					if (0 <= nr && nr < R && 0 <= nc && nc < C && !v[nr][nc]) {
						v[nr][nc] = true;
						if(map[nr][nc]) {
							map[nr][nc] = false;
							queue[next].offer(new int[] {nr, nc});
							cheeze--;
						} else {
							queue[curr].offer(new int[] {nr, nc});
						}
					}
				}
			}
			curr ^= 1;
			next ^= 1;
			cnt++;
		}

		System.out.println(cnt);
		System.out.println(queue[curr].size());
	}
}