package SWEA.D1;

import java.util.Scanner;

// 1933. 간단한 N 의 약수
public class Solution_2025 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				System.out.print(i + " ");
			}
		}
		sc.close();
	}

}
