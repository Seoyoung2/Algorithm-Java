package Jungol;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 1661 : 미로 탈출 로봇
public class Main_1661 {
	static int[][] dxdy = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
	static int[][] map;
	static boolean[][] visit;
	static int R, C;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		R = sc.nextInt();
		
		int start_x = sc.nextInt();
		int start_y = sc.nextInt();
		int end_x = sc.nextInt();
		int end_y = sc.nextInt();
		
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			String tmp = sc.next();
			for (int j = 0; j < C; j++)
				map[i][j] = tmp.charAt(j) - '0';
		}
		
		visit = new boolean[R][C];
		System.out.println(bfs(start_x-1, start_y-1, end_x-1, end_y-1));
	}
	static class Node{
		int x, y, dist;
		Node(int x, int y, int d){
			this.x = x;
			this.y = y;
			this.dist = d;
		}
	}
	
	static int bfs(int sx, int sy, int ex, int ey) {
		int nx, ny, cnt = 0;
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(sy, sx, 0));
		top:
		while(!q.isEmpty()) {
			Node no = q.poll();
			for (int i = 0; i < 4; i++) {
				nx = no.x + dxdy[i][0];
				ny = no.y + dxdy[i][1];
				if(nx<0 || nx>=R || ny<0 || ny>=C)	continue;
				if(nx == ey && ny == ex) {
					cnt = no.dist+1;
					break top;
				}
				if(map[nx][ny] == 0 && !visit[nx][ny]) {
					visit[nx][ny] = true;
					q.offer(new Node(nx, ny, no.dist+1));
				}
			}
		}
		return cnt;
	}
}
