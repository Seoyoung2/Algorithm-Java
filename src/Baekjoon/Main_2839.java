package Baekjoon;

import java.util.Scanner;

// 2839. 설탕 배달
public class Main_2839 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int cnt = 0;
		while(N > 0) {
			if(N % 5 == 0) {
				cnt += N / 5;
				break;
			}
			N -= 3;
			if(N < 0) {
				cnt = -1;
				break;
			}
			cnt++;
		}
		System.out.println(cnt);
	}
	
}
