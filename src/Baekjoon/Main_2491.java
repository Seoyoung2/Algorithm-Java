package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2491. 수열
public class Main_2491 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] num = new int[n][2];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int prev = Integer.parseInt(st.nextToken());
		
		int val, ans = 0;
		for (int i = 1; i < n; i++) {
			val = Integer.parseInt(st.nextToken());
			if(val >= prev) num[i][0] = num[i-1][0] + 1;
			if(val <= prev)	num[i][1] = num[i-1][1] + 1;
			prev = val;
			ans = Math.max(ans, Math.max(num[i][0], num[i][1]));
		}
		System.out.println(ans+1);
	}
}
