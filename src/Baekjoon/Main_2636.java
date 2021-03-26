package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 2636. 치즈
public class Main_2636 {
	static int N, M, cnt;
	static boolean[][] C, out;
	static int[][] dxdy = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        C = new boolean[N+2][M+2];
        for (int i = 1; i <= N; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				C[i][j] = (st.nextToken().charAt(0) == '1');
				if(C[i][j])	cnt++;
			}
		}
        
        int ans = 0, tcnt=0;
        while(cnt>0) {
        	ans++;
        	tcnt = cnt;
            out = new boolean[N+2][M+2];
        	checkOut();
        	bfs();
        }
        System.out.println(ans + "\n" + tcnt);
	}

	static void checkOut() {
		LinkedList<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0});
		out[0][0] = true;
		
		int x, y, nx, ny;
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.poll()[1];
			for (int i = 0; i < 4; i++) {
				nx = x + dxdy[i][0];
				ny = y + dxdy[i][1];
				if(nx<0 || nx>=N+2 || ny<0 || ny>=M+2 || out[nx][ny] || C[nx][ny])	continue;
				out[nx][ny] = true;
				q.add(new int[] {nx, ny});
			}
		}
	}

	static void bfs() {
		for (int x = 1; x <= N; x++) {
			for (int y = 1; y <= M; y++) {
				if(out[x][y] || !C[x][y])	continue;
				int nx, ny;
				for (int i = 0; i < 4; i++) {
					nx = x + dxdy[i][0];
					ny = y + dxdy[i][1];
					if(nx<1 || nx>=N+1 || ny<1 || ny>=M+1)	continue;
					if(out[nx][ny]) {
						cnt--;
						C[x][y] = false;
						break;
					}
				}
			}
		}
	}
}
