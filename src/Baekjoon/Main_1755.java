package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 1755. 숫자놀이
public class Main_1755 {
	
	static class Num implements Comparable<Num>{
		int n;			
		String str;		
		
		Num(int n, String str){
			this.n = n;
			this.str = str;
		}

		@Override
		public int compareTo(Num o) {
			// 문자열로 sorting
			return this.str.compareTo(o.str);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		String[] alpha = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		String[] dp = new String[100];
		
		for (int i = 0; i < 10; i++) {
			dp[i] = alpha[i];
		}
		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				dp[10*i+j] = alpha[i] + alpha[j];
			}
		}
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		ArrayList<Num> list = new ArrayList<>(N-M+1);
		for (int i = M; i <= N; i++) {
			list.add(new Num(i, dp[i]));
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < N-M+1; i++) {
			if(i != 0 && i % 10 == 0)	System.out.println();
			System.out.print(list.get(i).n + " ");
		}
		
	}

}
