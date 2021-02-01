package SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 6730. 장애물 경주 난이도
public class Solution_6730 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			int up = 0, down = 0;
			int prev = Integer.parseInt(st.nextToken());
			for (int i = 1; i < n; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp > prev)
					up = Math.max(up, tmp-prev);
				else
					down = Math.max(down, prev-tmp);
				prev = tmp;
			}
			System.out.println("#" + tc + " " + up + " " + down);
		}
	}
}
