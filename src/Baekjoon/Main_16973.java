package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 16973. 직사각형 탈출
public class Main_16973 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] dxdy = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        boolean[][] map = new boolean[N+1][M+1];
        boolean[][] visit = new boolean[N+1][M+1];

        for (int i = 1; i <= N; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++)
				map[i][j] = st.nextToken().equals("1");
		}
        
        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int Sr = Integer.parseInt(st.nextToken());
        int Sc = Integer.parseInt(st.nextToken());
        int Fr = Integer.parseInt(st.nextToken());
        int Fc = Integer.parseInt(st.nextToken());
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {Sr, Sc, 0});
        visit[Sr][Sc] = true;
        
        int cur[], nx, ny;
        while(!q.isEmpty()) {
        	cur = q.poll();
        	if(cur[0] == Fr && cur[1] == Fc) {
        		System.out.println(cur[2]);
        		return;
        	}
        	dir:
        	for (int[] d : dxdy) {
				nx = cur[0] + d[0];
				ny = cur[1] + d[1];
				if(nx<1 || nx>N-H+1 || ny<1 || ny>M-W+1 || visit[nx][ny])	continue;
				
				for (int i = nx; i < nx+H; i++) {
					for (int j = ny; j < ny+W; j++) {
						if(map[i][j])	continue dir;	
					}
				}
				q.offer(new int[] {nx, ny, cur[2]+1});
				visit[nx][ny] = true;
			}
        }
        System.out.println(-1);
	}
}

