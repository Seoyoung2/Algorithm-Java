package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 7576. 토마토 
public class Main_7576 {
	static int[][] dxdy = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[][] tom = new int[N][M];
        Queue<int[]> q = new LinkedList<>();
        
        int zero = 0;
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tom[i][j] = Integer.parseInt(st.nextToken());
				if(tom[i][j] == 1)	q.offer(new int[] {i, j});
				else if(tom[i][j] == 0)	zero++;
			}
		}
        
        int ans = 0, size;
        int cur[], nx, ny;
        while(!q.isEmpty()) {
        	ans++;
        	size = q.size();
        	
        	for (int i = 0; i < size; i++) {
				cur = q.poll();
				for (int j = 0; j < 4; j++) {
					nx = cur[0] + dxdy[j][0];
					ny = cur[1] + dxdy[j][1];
					if(nx>=0 && nx<N && ny>=0 && ny<M && tom[nx][ny]==0) {
						tom[nx][ny] = 1;
						q.offer(new int[] {nx, ny});
						zero--;
					}
				}
			}
        }
        System.out.println(zero==0? ans-1 : -1);
	}
}
