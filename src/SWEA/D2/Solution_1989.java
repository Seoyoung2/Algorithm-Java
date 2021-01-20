package SWEA.D2;

import java.util.Scanner;

// 1989. 초심자의 회문 검사
public class Solution_1989 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {	
			int ans = 1;
			String str = sc.next();
			int sl = str.length();
			for (int j = 0; j < sl/2; j++) {
				if (str.charAt(j) != str.charAt(sl-j-1)) {
					ans = 0;
					break;
				}
			}
			System.out.println("#" + i + " " + ans);
		}
		sc.close();
	}
}
