package SWEA.D2;

import java.util.Scanner;

// 1284. 수도 요금 경쟁
public class Solution_1284 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int p, q, r, s, w, ans1, ans2;
		for (int tc = 1; tc <= T; tc++) {
			// A사는 1L당 P원, B사는 기본료 Q원 그리고 RL 초과시 1당 S원
			p = sc.nextInt();
			q = sc.nextInt();
			r = sc.nextInt();
			s = sc.nextInt();
			w = sc.nextInt(); // 한달 사용량
			
			ans1 = w * p;
			ans2 = q;
			if (w > r)
				ans2 += (w-r) * s;
			System.out.println("#" + tc + " " + Math.min(ans1, ans2));

		}
		sc.close();
	}
}
