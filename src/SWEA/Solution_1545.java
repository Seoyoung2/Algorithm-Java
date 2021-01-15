package SWEA;

import java.util.Scanner;

public class Solution_1545 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		String ans = "";
		while (n>=0) {
			ans += Integer.toString(n--) + " ";
		}
		System.out.println(ans);
	}
}
