package SWEA.D3;

import java.util.Scanner;

// 4406. 모음이 보이지 않는 사람
public class Solution_4406 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder ans;
		char[] chs = {'a', 'e', 'i', 'o', 'u'};
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			ans = new StringBuilder();
			String str = sc.next();
			for (int i = 0; i < str.length(); i++) {
				int j;
				char ch = str.charAt(i);
				for (j = 0; j < 5; j++)
					if (ch == chs[j])
						break;
				if (j == 5)
					ans.append(ch);
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
