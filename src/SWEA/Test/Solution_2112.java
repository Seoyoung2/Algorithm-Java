package SWEA.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 2112. [모의 SW 역량테스트] 보호 필름
public class Solution_2112 {
	static int D, W, K, ans;
	static boolean film[][], tfilm[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			film = new boolean[D][W];
			tfilm = new boolean[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++)
					film[i][j] = tfilm[i][j] = st.nextToken().equals("1");
			}
			
			ans = Integer.MAX_VALUE;
			if(K == 1 || checkRow()) {
				ans = 0;
			}else {
				inject(0, 0);
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void inject(int idx, int cnt) {
		if(cnt >= ans)	return;
		if(idx == D) {
			if(checkRow())	ans = Math.min(ans, cnt);
			return;
		}
		
		inject(idx+1, cnt);
		
		for (int i = 0; i < W; i++)	tfilm[idx][i] = true;
		inject(idx+1, cnt+1);
		
		for (int i = 0; i < W; i++)	tfilm[idx][i] = false;
		inject(idx+1, cnt+1);
		
		for (int i = 0; i < W; i++)	tfilm[idx][i] = film[idx][i];
	}

	static boolean checkRow() {
		top:
		for (int j = 0; j < W; j++) {
			boolean prev = tfilm[0][j];
			int cnt = 1;
			for (int i = 1; i < D; i++) {
				if(tfilm[i][j] == prev) {
					if(++cnt == K)	continue top;
				}else {
					prev = tfilm[i][j];
					cnt = 1;
				}
			}
			return false;
		}
		return true;
	}
	
}

/*
12 2 6
1 1
1 1
1 1
1 0
1 0
0 1
0 1
0 0
0 0
1 0
1 0
1 0

ans : 2
 * */
