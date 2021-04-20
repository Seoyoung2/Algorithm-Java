package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 8382. 방향 전환
public class Solution_8382 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int x1, x2, y1, y2, dx, dy;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			/* 0  1  4  5
			 * 1  2  3  6 -> 4 6
			 * 4  3  4  5 -> 1 3 5
			 * 5  6  5  6 -> 0 2 4 6
			 */
			int ans = 0;
			
			dx = Math.abs(x1-x2);
			dy = Math.abs(y1-y2);
			
			int big = Math.max(dx, dy);
            int small = Math.min(dx, dy);
            int differ = big - small;
 
            ans = 2 * small + 2 * (big - small) - ((big-small) % 2);
            ans = 2 * small + 2 * differ - (differ % 2);
			System.out.println("#" + tc + " " + ans);
		}

	}
}
