package SWEA.D2;

import java.util.Scanner;

// 1959. 두 개의 숫자열
public class Solution_1959 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int[] narr = new int[n];
			int[] marr = new int[m];
			for (int j = 0; j < n; j++) {
				narr[j] = sc.nextInt();
			}
			for (int j = 0; j < m; j++) {
				marr[j] = sc.nextInt();
			}
			
			if (n > m) {
				for (int i = 0; i <= n-m; i++) {
					int tmp = 0;
					for (int j = 0; j < m; j++) {
						tmp += narr[i+j]*marr[j];
					}
					ans = Math.max(ans, tmp);
				}
			} else {
				for (int i = 0; i <= m-n; i++) {
					int tmp = 0;
					for (int j = 0; j < n; j++) {
						tmp += marr[i+j]*narr[j];
					}
					ans = Math.max(ans, tmp);
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}
