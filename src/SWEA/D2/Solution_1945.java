package SWEA.D2;

import java.util.Scanner;

// 1945. 간단한 소인수분해 
public class Solution_1945 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] nums = {2, 3, 5, 7, 11};
		
		for (int i = 1; i <= T; i++) {
			int n = sc.nextInt();
			System.out.print("#" + i);
			for (int num : nums) {
				int cnt = 0;
				while (n % num == 0) {
					n /= num;
					cnt++;
				}
				System.out.print(" " + cnt);
			}
			System.out.println();
		}
		sc.close();
	}
}
