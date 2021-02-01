package SWEA.D3;

import java.util.Scanner;

// 3431. 준환이의 운동관리
public class Solution_3431 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int L, U, X;
		for (int tc = 1; tc <= T; tc++) {
			int res = 0;
			L = sc.nextInt();
			U = sc.nextInt();
			X = sc.nextInt();
			
			if (X > U) {
				res = -1;
			} else if (X < L) {
				res = L - X;
			}
			System.out.println("#" + tc + " " + res);
		}
	}
}
