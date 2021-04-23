package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 1868. 파핑파핑 지뢰찾기
public class Solution_1868 {
	static int N;
	static char map[][];
	static int[][] dxdy = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++)
					map[i][j] = line.charAt(j);
			}
			
			int nx, ny;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == '.') {
						int cnt = 0;
						for (int[] d : dxdy) {
							nx = i + d[0];
							ny = j + d[1];
							if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny]=='*')	cnt++;
						}
						map[i][j] = Character.forDigit(cnt, 10);
					}
				}
			}
			
			int ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == '0') {
						ans++;
						dfs(i, j);
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] != '*')	ans++;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void dfs(int x, int y) {
		map[x][y] = '*';
		for (int[] d : dxdy) {
			int nx = x + d[0];
			int ny = y + d[1];
			if(nx>=0 && nx<N && ny>=0 && ny<N) {
				if(map[nx][ny] == '0')	dfs(nx, ny);
				map[nx][ny] = '*';
			}
		}

	}
}
