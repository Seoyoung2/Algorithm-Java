package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1987. 알파벳
public class Main_1987 {
	static int[][] dxdy = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int R, C, ans;
	static char[][] board;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		board = new char[R][C];
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		visit = new boolean[26];
		visit[board[0][0]-'A'] = true;
		dfs(0, 0, 1);
		System.out.println(ans);
	}

	private static void dfs(int x, int y, int cnt) {
		int nx, ny;
		for (int i = 0; i < 4; i++) {
			nx = x + dxdy[i][0];
			ny = y + dxdy[i][1];
			if(nx<0 || nx>=R || ny<0 || ny>=C)	continue;
			
			int tmp = board[nx][ny] - 'A';
			if(!visit[tmp]) {
				visit[tmp] = true;
				dfs(nx, ny, cnt+1);
				visit[tmp] = false;
			}
		}
		ans = Math.max(ans, cnt);
	}
}
