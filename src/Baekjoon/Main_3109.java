package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3109 {
	static int R, C;
	static int[][] dxdy = {{-1, 1}, {0, 1}, {1, 1}};
	static int ans;
	static char[][] pipe;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		
		pipe = new char[R][C];
		for (int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < C; j++) {
				pipe[i][j] = tmp.charAt(j);
			}
		}
		
		for (int i = 0; i < R; i++)
			dfs(i, 0);
		System.out.println(ans);
	}
	
	static boolean dfs(int x, int y) {
		int nx, ny;
		if(y == C-1) {
			ans++;
			return true;
		}
			
		for (int i = 0; i < 3; i++) {
			nx = x+dxdy[i][0];
			ny = y+dxdy[i][1];
			if(nx<0 || nx>=R || ny>=C || pipe[nx][ny] != '.')	continue;
			
			pipe[nx][ny] = 'O';
			if(dfs(nx, ny))	return true;
		}
		return false;
	}
}
