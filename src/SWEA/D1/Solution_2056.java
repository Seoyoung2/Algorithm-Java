package SWEA.D1;

import java.util.Scanner;

// 연월일 달력 (2056)
public class Solution_2056 {

	public static void main(String[] args) {
		int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			String n = sc.next();
			
			int year = Integer.parseInt(n.substring(0, 4));
			int month = Integer.parseInt(n.substring(4, 6));
			int day = Integer.parseInt(n.substring(6, 8));
			
			if (month >= 1 && month <= 12) {
				if (day >= 1 && day <= days[month-1]) {
					System.out.printf("#%d %04d/%02d/%02d\n", i, year, month, day);
					continue;
				}
			}
			System.out.println("#" + i + " -1");
		}
		sc.close();
	}

}
