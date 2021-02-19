package SWEA.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 4012. [모의 SW 역량테스트] 요리사
public class Solution_4012 {
	static int N, ans;
	static int[][] food;
	static boolean[] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			food = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					food[i][j] = Integer.parseInt(st.nextToken());
			}

			ans = Integer.MAX_VALUE;
			visit = new boolean[N];
			combi(0, 0);
			
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void combi(int cnt, int start) {
		if(cnt == N/2) {
			ans = Math.min(ans, cook());
			return;
		}
		for (int i = start; i < N; i++) {
			visit[i] = true;
			combi(cnt+1, i+1);
			visit[i] = false;
		}
	}

	static int cook() {
		ArrayList<Integer> A = new ArrayList<>(N/2);
		ArrayList<Integer> B = new ArrayList<>(N/2);
		
		for (int i = 0; i < N; i++) {
			if(visit[i])	A.add(i);
			else			B.add(i);
		}
		
		int cookA = 0, cookB = 0;
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < N/2; j++) {
				cookA += food[A.get(i)][A.get(j)];
				cookB += food[B.get(i)][B.get(j)];
			}
		}
		return Math.abs(cookA-cookB);
	}
}
