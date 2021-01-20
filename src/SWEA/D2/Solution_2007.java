package SWEA.D2;

import java.util.Scanner;

public class Solution_2007 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {	
			int ans = 0;
			String str = sc.next();
			for (int j = 1; j <= str.length()/2; j++) {
				String pattern = str.substring(0, j);
				String tmp = str.substring(j, 2*j);
				if (pattern.equals(tmp)) {
					ans = pattern.length();
					break;
				}
			}
			System.out.println("#" + i + " " + ans);
		}
		sc.close();
	}
}
