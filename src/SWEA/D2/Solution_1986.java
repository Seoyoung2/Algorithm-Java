package SWEA.D2;

import java.util.Scanner;

public class Solution_1986 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[11];
		nums[0] = 0;
		
		for (int i = 1, j = 1; i < 10; i+=2, j+=2) {
			nums[i] = nums[i-1] + j;
			nums[i+1] = nums[i] - (j+1);
		}

		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int n = sc.nextInt();
			System.out.println("#" + i + " " + nums[n]);
		}
		sc.close();
	}

}
