package SWEA.D1;

import java.util.Scanner;

// 2019. 더블더블
public class Solution_2019 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int res = 1;
		for (int i = 0; i <= n; i++) {
			System.out.print(res + " ");
			res *= 2;
		}
		sc.close();
	}

}
