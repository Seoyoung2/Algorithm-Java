package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 16918. 봄버맨
public class Main_16918 {
	static char[][] map;
	static int R, C, N;
	static LinkedList<int[]> bomb = new LinkedList<>();
	static int[][] dxdy = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == '0')	bomb.add(new int[] {i, j});
			}
		}
		
		go();
	}

	static void go() {
		char[][] tmp;
		LinkedList<int[]> tmp_bomb;
		
		int x, y, nx, ny;
		while(!bomb.isEmpty()) {
			tmp_bomb = (LinkedList<int[]>) bomb.clone();
			bomb.clear();
			while(!tmp_bomb.isEmpty()) {
				x = tmp_bomb.peek()[1];
				y = tmp_bomb.poll()[1];
				for (int i = 0; i < 4; i++) {
					nx = x + dxdy[i][0];
					ny = y + dxdy[i][1];
					if(nx<0 || nx>=R || ny<0 || ny>C || map[nx][ny]=='.')	continue;
					// 폭탄이 있으면
					bomb.add(new int[] {nx, ny});
					map[nx][ny] = '.';
				}
			}
		}
	}
}