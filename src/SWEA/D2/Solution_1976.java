package SWEA.D2;

import java.util.Scanner;

// 1976. 시각 덧셈
public class Solution_1976 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int hour, min;
		for (int tc = 1; tc <= T; tc++) {
			int shour = sc.nextInt();
			int smin = sc.nextInt();
			int ehour = sc.nextInt();
			int emin = sc.nextInt();
			
			hour = shour + ehour;
			min = smin + emin;
			if (min>59) {
				hour++;
				min-=60;
			}
			if (hour>12) hour -= 12;
			System.out.printf("#%d %d %d\n", tc, hour, min);
		}
		sc.close();
	}
}
