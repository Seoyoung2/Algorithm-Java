package SWEA.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 5644. [모의 SW 역량테스트] 무선 충전

public class Solution_5644 {
	static int M, A, X, Y, C, P;
	static ArrayList<Integer> map[][];
	static int pathA[], pathB[], sum;
	static int[][] dxdy = {{0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());

			pathA = new int[M+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				pathA[i] = Integer.parseInt(st.nextToken());
			}
			pathB = new int[M+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				pathB[i] = Integer.parseInt(st.nextToken());
			}

			map = new ArrayList[10][10];
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					map[i][j] = new ArrayList<Integer>();
				}
			}

			ArrayList<Integer> BC = new ArrayList<>();
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				X = Integer.parseInt(st.nextToken())-1;
				Y = Integer.parseInt(st.nextToken())-1;
				C = Integer.parseInt(st.nextToken());
				P = Integer.parseInt(st.nextToken());

				BC.add(P);
				bfs(Y, X, C, i);
			}

			sum = 0;
			int ax=0, ay=0, bx=9, by=9;
			PriorityQueue<Integer> A, B;
			for (int i = 0; i <= M; i++) {
				ax += dxdy[pathA[i]][0];
				ay += dxdy[pathA[i]][1];
				bx += dxdy[pathB[i]][0];
				by += dxdy[pathB[i]][1];
				A = new PriorityQueue<>((x, y) -> y - x);
				B = new PriorityQueue<>((x, y) -> y - x);
				for (Integer it : map[ax][ay]) {
					A.add(BC.get(it));
				}
				for (Integer it : map[bx][by]) {
					B.add(BC.get(it));
				}

				if(A.isEmpty() && !B.isEmpty()) {
					sum += B.peek();
				} else if(!A.isEmpty() && B.isEmpty()) {
					sum += A.peek();
				} else if(!A.isEmpty() && !B.isEmpty()) {
					if(A.peek() == B.peek()) {
						A.poll();
						sum += B.poll();

						if(A.isEmpty() && B.isEmpty()) {}
						else if(A.isEmpty())	sum += B.peek();
						else if(B.isEmpty())	sum += A.peek();
						else if(A.peek() < B.peek())	sum += B.peek();
						else					sum += A.peek();
					} else {
						sum += (A.peek() + B.peek());
					}
				}
			}
			System.out.printf("#%d %d\n", tc, sum);
		}
	}

	static void bfs(int x, int y, int c, int idx) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visit = new boolean[10][10];
		visit[x][y] = true;
		q.offer(new int[] {x, y, 0});
		map[x][y].add(idx);
		
		int nx, ny;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[2] == c)	break;
			for (int[] d : dxdy) {
				nx = cur[0] + d[0];
				ny = cur[1] + d[1];
				if(nx<0 || nx>=10 || ny<0 || ny>=10 || visit[nx][ny])	continue;
				visit[nx][ny] = true;
				map[nx][ny].add(idx);
				q.offer(new int[] {nx, ny, cur[2]+1});
			}
		}
	}
}