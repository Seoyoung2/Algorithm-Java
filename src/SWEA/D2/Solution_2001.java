package SWEA.D2;

import java.util.Scanner;

public class Solution_2001 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, m, fly[][];
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {	
			n = sc.nextInt();
			m = sc.nextInt();
			fly = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					fly[i][j] = sc.nextInt();
			
			int ans = 0;
			for (int i = 0; i <= n-m; i++) {
				for (int j = 0; j <= n-m; j++) {
					int tmp = 0;
					for (int k = i; k < m+i; k++)
						for (int k2 = j; k2 < m+j; k2++)
							tmp += fly[k][k2];
					ans = Math.max(ans,  tmp);
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}
