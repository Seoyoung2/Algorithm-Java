package SWEA.D3;

import java.util.Scanner;

// 2805. 농작물 수확하기
public class Solution_2805 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int[][] farm = new int[n][n];
			for (int i = 0; i < n; i++) {
				String nums = sc.next();
				farm[i] = new int[n];
				for (int j = 0; j < n; j++)
					farm[i][j] = nums.charAt(j) - '0';
			}
			int cnt = 0;
			int n2 = n/2;
			for (int i = 0; i < n; i++)
				cnt += (farm[n2][i] + farm[i][n2]);
			cnt -= farm[n2][n2];
			for (int i = 1; i <= n2; i++)
				for (int j = 1; j <= n2-i; j++)
					cnt += (farm[n2-i][n2-j] + farm[n2-i][n2+j] + farm[n2+i][n2-j] + farm[n2+i][n2+j]);
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
