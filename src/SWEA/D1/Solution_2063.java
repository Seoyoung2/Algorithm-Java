package SWEA.D1;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_2063 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		System.out.println(arr[n/2]);
		sc.close();
	}

}
