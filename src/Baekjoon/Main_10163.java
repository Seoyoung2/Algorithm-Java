package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 10163. 색종이
public class Main_10163 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int[][] space = new int[101][101];
		
		int N = Integer.parseInt(br.readLine());
		int x, y, w, h;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			for (int j = x; j <x+w; j++)
				for (int k = y; k < y+h; k++)
					space[j][k] = i;
		}
		
		int[] cnt = new int[101];
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if(space[i][j] == 0)	continue;
				cnt[space[i][j]]++;
			}
		}
		
		for (int i = 1; i <= N; i++)
			System.out.println(cnt[i]);
	}
	
}
