package SWEA.D4;

import java.util.Scanner;

// 5604. [Professional] 구간 합
public class Solution_5604 {
	static int T;
	static long A, B, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			A = sc.nextLong();
			B = sc.nextLong();
			ans = 0;
			long mul = 1;
			while (A <= B) {
				while (A % 10 != 0 && A <= B) {
					check(A, mul);
					A++;
				}
				if (A > B || (A == 0 && B == 0))	break;
				while (B % 10 != 9 && A <= B) {
					check(B, mul);
					B--;
				}
				A /= 10;
				B /= 10;
				long m = (B - A + 1) * mul;
				for (int i = 0; i < 10; i++)
					ans += m * i;
				mul *= 10;
			}
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}

	static void check(long n, long t) {
		while (n > 0) {
			ans += (n % 10) * t;
			n /= 10;
		}
	}

}
