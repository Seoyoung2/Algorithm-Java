package SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 10804. 문자열의 거울상
public class Solution_10804 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str = in.readLine();
			String ans = "";
			
			for (int i = str.length()-1; i >= 0; i--) {
				char ch = str.charAt(i);
				if (ch == 'p')	ans += 'q';
				else if(ch == 'q')	ans += 'p';
				else if(ch == 'b')	ans += 'd';
				else	ans += 'b';
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
