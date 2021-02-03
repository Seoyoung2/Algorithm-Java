package SWEA.D3;

import java.util.Scanner;

// 1873. 상호의 배틀필드
public class Solution_1873 {
	static int[][] dxdy = {{0,0}, {-1,0}, {1,0}, {0,-1}, {0,1}};
	static int d;
	static char[][] map;
	static int x, y, w, h;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			
			// 입력받기
			h = sc.nextInt();
			w = sc.nextInt();
			map = new char[h][w];
			for (int i = 0; i < h; i++) {
				String str = sc.next();
				for (int j = 0; j < w; j++) {
					char ch = str.charAt(j);
					map[i][j] = ch;
					if(ch == '>' || ch == '<' || ch == '^' || ch == 'v') {
						if(ch == '^') d = 1;
						if(ch == 'v') d = 2;
						if(ch == '<') d = 3;
						if(ch == '>') d = 4;
						x = i; y = j;
					}
				}
			}
			int n = sc.nextInt();
			String order = sc.next();
			for (int i = 0; i < n; i++) {
				char ord = order.charAt(i);
				switch (ord) {
				case 'U':
					d = 1;
					map[x][y] = '^';
					move();
					break;
				case 'D':
					d = 2;
					map[x][y] = 'v';
					move();
					break;
				case 'R':
					d = 4;
					map[x][y] = '>';
					move();
					break;
				case 'L':
					d = 3;
					map[x][y] = '<';
					move();
					break;
				case 'S':
					shoot();
					break;
				}
			}
			
			System.out.print("#" + t + " ");
			for (char[] chs : map) {
				for (char ch : chs)
					System.out.print(ch);
				System.out.println();
			}
		}
	}
	
	static void move() {
		int nx = x+dxdy[d][0], ny = y+dxdy[d][1];
		if(nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] != '.') return;
		map[nx][ny] = map[x][y];
		map[x][y] = '.';
		x = nx; y = ny;
	}
	
	static void shoot() {
		int nx = x, ny = y;
		// 방향 알고 슈팅하기
		while(true) {
			nx += dxdy[d][0];
			ny += dxdy[d][1];
			// map을 벗어나거나 강철벽에 부딪히면 끝
			if(nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] == '#') break;
			else if(map[nx][ny] == '*') {
				map[nx][ny] = '.';
				break;
			}
		}
	}
}
