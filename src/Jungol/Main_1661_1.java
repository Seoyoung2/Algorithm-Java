package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1661 : 미로 탈출 로봇
public class Main_1661_1 {
	static int[][] dxdy = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
	static int[][] map;
	static int R, C, ex, ey, ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int sx = Integer.parseInt(st.nextToken());
		int sy = Integer.parseInt(st.nextToken());
		ex = Integer.parseInt(st.nextToken());
		ey = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < C; j++)
				map[i][j] = tmp.charAt(j) - '0';
		}
		
		ans = Integer.MAX_VALUE;
		dfs(sy-1, sx-1);
		System.out.println(ans);
	}
	static class Node{
		int x, y, dist;
		Node(int x, int y, int d){
			this.x = x;
			this.y = y;
			this.dist = d;
		}
	}
	
	static void dfs(int x, int y) {
		if(x == ey-1 && y == ex-1) {
			return;
		}
		int dist = map[x][y];
		int nx, ny;
		for (int i = 0; i < 4; i++) {
			nx = x + dxdy[i][0];
			ny = y + dxdy[i][1];
			if(nx<0 || nx>=R || ny<0 || ny>=C || map[nx][ny] != 0 || map[nx][ny] <= dist)	continue;
	        map[nx][ny] = dist+1;
	        dfs(nx, ny);
		}
	}
	
}
