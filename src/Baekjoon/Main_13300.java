package Baekjoon;

import java.util.Scanner;

// 13300. 방 배정
public class Main_13300 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double K = sc.nextDouble();
		
		int[] boy = new int[6];
		int[] girl = new int[6];
		
		for (int i = 0; i < N; i++) {
			int S = sc.nextInt();
			int Y = sc.nextInt()-1;
			if(S == 0)	girl[Y]++;
			else		boy[Y]++;
		}
		
		int ans = 0;
		for (int i = 0; i < 6; i++) {
			ans += (Math.ceil(girl[i]/K) + Math.ceil(boy[i]/K));
		}
		System.out.println(ans);
	}
}
