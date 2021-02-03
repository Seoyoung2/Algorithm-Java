package Jungol;

import java.util.Scanner;

public class Main_1810 {
	static int[] height;
	static int[] ans;
	static int sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		height = new int[9];
		ans = new int[7];
		for (int i = 0; i < 9; i++)
			height[i] = sc.nextInt();
		combination(0, 0);
	}
	
	private static void combination(int idx, int start) {
		if(idx == 7) {
			if(sum == 100) {
				for (int i : ans)
					System.out.println(i);
				System.exit(0);
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			ans[idx] = height[i];
			sum += height[i];
			combination(idx+1, i+1);
			sum -= height[i];
		}
	}
}
