package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1681 : 해밀턴 순환회로
public class Main_1681 {
	static int N, ans = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visit = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit[0] = true;
		go(0, 0, 0);
		System.out.println(ans);
	}

	static void go(int now, int idx, int cost) {
		if(idx == N-1) {
			if(map[now][0] == 0)	return;
			ans = Math.min(ans, cost + map[now][0]);
			return;
		}
		if(cost >= ans)	return;
		for (int i = 0; i < N; i++) {
			if(!visit[i] && map[now][i] != 0) {
				visit[i] = true;
				go(i, idx+1, cost+map[now][i]);
				visit[i] = false;
			}
		}
	}
}
