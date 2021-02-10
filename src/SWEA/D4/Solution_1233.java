package SWEA.D4;

import java.util.Scanner;

// 1233. [S/W 문제해결 기본] 9일차 - 사칙연산 유효성 검사
public class Solution_1233 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			int ans = 1;
			int n = sc.nextInt();
			sc.nextLine();
			
			for (int i = 1; i <= n; i++) {
				String[] str = sc.nextLine().split(" ");
				if(ans == 0)	continue;
				if(str[1].equals("+") || str[1].equals("-") || str[1].equals("*") || str[1].equals("/")) {
					if(str.length != 4)		ans = 0;
				} 
				else if(str.length != 2)	ans = 0;
			}
			System.out.println("#"+t+" "+ans);
		}
	}
}
