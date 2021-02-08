package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

// 15657. N과 M (8)
public class Main_15657 {
	static int N, M;
	static int[] num, select;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		num = new int[N];
		for (int i = 0; i < N; i++)
			num[i] = sc.nextInt();
		Arrays.sort(num);
		
		select = new int[M];
		combi(0, 0);
	}
	
	static void combi(int cnt, int start) {
		if(cnt == M) {
			Arrays.sort(select);
			for (int i : select)
				System.out.print(i+" ");
			System.out.println();
			return;
		}
		for (int i = start; i < N; i++) {
			select[cnt] = num[i];
			combi(cnt+1, i);
		}
	}
}
