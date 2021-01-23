package SWEA.D2;

import java.util.Scanner;

// 1970. 쉬운 거스름돈
public class Solution_1970 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] coins = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		
		for (int i = 1; i <= T; i++) {
			System.out.println("#" + i);

			int price = sc.nextInt();
			for (int coin : coins) {
				int cnt = 0;
				if (price >= coin) {
					cnt = price / coin;
					price -= coin*cnt;
				}
				System.out.print(cnt + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}
