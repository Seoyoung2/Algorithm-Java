package Baekjoon;

import java.util.Scanner;

// 1244. 스위치 켜고 끄기
public class Main_1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] light = new int[n+1];
		for (int i = 1; i <= n; i++)
			light[i] = sc.nextInt();
		
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int gender = sc.nextInt();
			int num = sc.nextInt();
			if(gender == 1) {
				for (int j = num; j <= n; j++)
					if(j % num == 0)
						light[j] = 1 - light[j];
			} else {
				light[num] = 1 - light[num];
				for (int j = 1; j < n/2; j++) {
					if (num-j <= 0 || num+j > n || light[num+j] != light[num-j]) break;
					light[num+j] = 1 - light[num+j];
					light[num-j] = 1 - light[num-j];
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			System.out.print(light[i]+" ");
			if (i % 20 == 0) {
	            System.out.println();
	        }
		}

	}
}
