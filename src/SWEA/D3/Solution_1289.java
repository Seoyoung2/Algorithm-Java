package SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1289. 원재의 메모리 복구하기
public class Solution_1289 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int cnt = 0;
			char[] str = in.readLine().toCharArray();
			int l = str.length;
			char[] str2 = new char[l];
			for (int i = 0; i < l; i++)	str2[i] = '0';
			for (int i = 0; i < l; i++) {
				if (str[i] != str2[i]) {
					cnt++;
					for (int j = i; j < l; j++)
						str2[j] = str[i];
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
