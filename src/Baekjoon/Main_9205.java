package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

// 9205. 맥주 마시면서 걸어가기
public class Main_9205 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int MAX = 10*7;
        
        int T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] X = new int[N+2];
			int[] Y = new int[N+2];
			
			for (int i = 0; i < N+2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				X[i] = x;	Y[i] = y;
			}
			
			int[][] map = new int[N+2][N+2];
			for (int i = 0; i < N+2; i++) {
				Arrays.fill(map[i], MAX);
			}
			
			for (int i = 0; i < N+2; i++) {
				for (int j = i+1; j < N+2; j++) {
					if(map[i][j]!=MAX)	continue;
					int dist = Math.abs(X[i]-X[j]) + Math.abs(Y[i]-Y[j]);
					if(dist <= 1000) {
						map[i][j] = map[j][i] = 1;
					}
				}
			}

			for (int k = 0; k < N+2; k++) {
				for (int i = 0; i < N+2; i++) {
					for (int j = 0; j < N+2; j++) {
						if(map[i][j] > map[i][k]+ map[k][j]) {
							map[i][j] = map[i][k]+ map[k][j];
						}
					}
				}
			}
			
			if(map[0][N+1] < MAX) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
		}
	}
}
