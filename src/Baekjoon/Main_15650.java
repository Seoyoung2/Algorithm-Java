package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

// 15650. N과 M (2)
public class Main_15650 {
	static int N, M;
	static int[] select;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		select = new int[M];
		permu(0, 1);
	}
	
	static void permu(int cnt, int start) {
		if(cnt == M) {
			Arrays.sort(select);
			for (int se : select)
				System.out.print(se+" ");
			System.out.println();
			return;
		}
		for (int i = start; i <= N; i++) {
			select[cnt] = i;
			permu(cnt+1, i+1);
		}
	}
}
