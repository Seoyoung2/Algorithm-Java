package SWEA.D2;

import java.util.Scanner;

public class Solution_2005 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {	
			int n = sc.nextInt();
			System.out.println("#" + tc);
			
			int[][] arr = new int[n][n];
			arr[0][0] = 1;
			System.out.println("1");
			for (int i = 1; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					if (j == 0) {
						arr[i][j] = 1;
					} else {
						arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
					}
				}
				for (int j = 0; j < n; j++) {
					if (arr[i][j] != 0) {
						System.out.print(arr[i][j] + " ");
					}
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
// 0,0
// 1,0 1,1
