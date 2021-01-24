package SWEA.D2;

import java.util.Scanner;

// 1948. 날짜 계산기
public class Solution_1948 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int smonth = sc.nextInt();
			int sday = sc.nextInt();
			int emonth = sc.nextInt();
			int eday = sc.nextInt();
			
			int cnt = 0;
			if (smonth < emonth) {
				cnt += (days[smonth]-sday+1);
			}
			for (int i = smonth+1; i < emonth; i++) {
				cnt += days[i];
			}
			cnt += eday;
			System.out.println("#" + tc + " " + cnt);
		}
		sc.close();
	}
}
