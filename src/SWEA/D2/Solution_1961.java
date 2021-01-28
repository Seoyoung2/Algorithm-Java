package SWEA.D2;

import java.util.Scanner;

// 1961. 숫자 배열 회전
public class Solution_1961 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					arr[i][j] = sc.nextInt();
			
			int[][] tmp1 = new int[n][n];
			int[][] tmp2 = new int[n][n];
			
		}
		sc.close();
	}
}
