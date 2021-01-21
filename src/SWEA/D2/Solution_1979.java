package SWEA.D2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1979 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {	
			int[] nums = new int[10];
			for (int j = 0; j < 10; j++) {
				nums[j] = sc.nextInt();
			}
			Arrays.sort(nums);	
			int sum = 0;
			for (int j = 1; j < 9; j++) {
				sum += nums[j];
			}
			System.out.println("#" + i + " " + Math.round((double)sum/8));
		}
		sc.close();
	}
}
