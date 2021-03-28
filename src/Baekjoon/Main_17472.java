package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 17472. 다리 만들기 2

/*
 * 1. 섬 구성 (섬마다 번호 부여, BFS)
 * 2. 최소간선트리(Kruskal or Prim) : 섬개수가 적으면 Prim이 좋음 (간만크, 간적프)
 */


public class Main_17472 {
	static int N, M, listCnt;
	static int[][] map;
	static LinkedList<int[]>[] list;
	static boolean[] visit;
	static int[][] dxdy = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
        
        int idx = 1;
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1)	bfs(++idx, i, j);
			}
		}
        
        // Prim Algorithm
        list = new LinkedList[idx+1];
        for (int i = 0; i <= idx; i++)	list[i] = new LinkedList<>();
        
        visit = new boolean[idx+1];
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] > 1) {
					if(j+1 < M && map[i][j+1] == 0)	makeRoad(i, j, dxdy[0]);
					if(i+1 < N && map[i+1][j] == 0)	makeRoad(i, j, dxdy[1]);
				}
			}
		}
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(N*M, (a, b) -> a[1]-b[1]);
        pq.add(new int[] {2, 0});
        
        int ans=0, cnt=1;
        int[] cur = new int[2];
        while(!pq.isEmpty()) {
        	cur = pq.poll();
        	if(visit[cur[0]])	continue;
        	visit[cur[0]] = true;
        	ans += cur[1];
        	if(++cnt == idx)	break;
        	for (int[] next : list[cur[0]]) {
				if(!visit[next[0]])	pq.add(next);
			}
        }

        if(cnt != idx)	ans = -1;
        System.out.println(ans);
	}

	static void makeRoad(int x, int y, int[] dir) {
		int base = map[x][y];
		int l = 0;

		int nx = x, ny = y;
		while(true){
			nx += dir[0];
			ny += dir[1];
			if(nx<0 || nx>=N || ny<0 || ny>=M || map[nx][ny] == base)	break;
			
			int to = map[nx][ny];
			if(to != 0) {
				if(l >= 2) {
					list[base].add(new int[] {to, l});
					list[to].add(new int[] {base, l});
					listCnt+=2;
				}
				break;
			}
			l++;
		}
	}

	static void bfs(int n, int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, j});
		map[i][j] = n;
		
		int x, y, nx, ny;
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.poll()[1];
			for (int k = 0; k < 4; k++) {
				nx = x + dxdy[k][0];
				ny = y + dxdy[k][1];
				if(nx<0 || nx>=N || ny<0 || ny>=M || map[nx][ny] != 1)	continue;
				map[nx][ny] = n;
				q.offer(new int[] {nx, ny});
			}	
		}
		
	}
}
