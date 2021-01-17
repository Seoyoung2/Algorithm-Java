package SWEA;

import java.util.Scanner;

public class Solution_2058 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		int ans = 0;
		for (int i = 0; i < n.length(); i++) {
			ans += n.charAt(i)-'0';
		}
		System.out.println(ans);
		sc.close();
	}

}
