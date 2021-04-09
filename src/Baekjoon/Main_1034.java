package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 1034. 램프
// 스위치를 K번 누른 후에 켜져있는 행의 최댓값
// 각 행의 0개수가 K보다 작아야함 + 0의개수와 K가 모두 짝수이거나 홀수이거나
public class Main_1034{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] light = new String[N];
		for (int i = 0; i < N; i++) {
			light[i] = br.readLine();
		}
		int K = Integer.parseInt(br.readLine());
		
		int K2 = K % 2;
		boolean[] check = new boolean[N];
		for (int i = 0; i < N; i++) {
			int zero = 0;
			for (int j = 0; j < M; j++) {
				if(light[i].charAt(j) == '0')	zero++;
			}
			if(zero <= K && zero%2 == K2)	check[i] = true;
		}
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			if(!check[i]) continue;
			
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if(light[i].equals(light[j])) {
					check[j] = false;
					cnt++;
				}
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
}
