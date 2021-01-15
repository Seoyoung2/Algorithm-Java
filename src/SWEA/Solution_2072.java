package SWEA;

import java.util.Scanner;

public class Solution_2072 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int n, sum;
		for (int i = 1; i <= T; i++) {
			sum = 0;
			for(int j = 0; j < 10; j++) {
				n = sc.nextInt();
				if (n % 2 == 1) {
					sum += n;
				}
			}
			System.out.println("#" + i +" " + sum);
		}
	}

}
