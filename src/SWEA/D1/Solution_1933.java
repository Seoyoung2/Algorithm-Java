package SWEA.D1;

import java.util.Scanner;

// 2025. N줄덧셈
public class Solution_1933 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		System.out.println(sum);
		sc.close();
	}

}
