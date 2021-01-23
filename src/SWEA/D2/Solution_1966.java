package SWEA.D2;

import java.util.Arrays;
import java.util.Scanner;

// 1966. 숫자를 정렬하자
public class Solution_1966 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int j = 0; j < n; j++) {
				nums[j] = sc.nextInt();
			}
			Arrays.sort(nums);
			System.out.print("#" + i);
			for (int j = 0; j < n; j++) {
				System.out.print(" " + nums[j]);
			}
			System.out.println();
		}
		sc.close();
	}

}
