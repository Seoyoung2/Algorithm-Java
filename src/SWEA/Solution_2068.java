package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2068 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			int max = 0;
			String str = br.readLine();
			st = new StringTokenizer(str);
			while (st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken());
				if (n > max)	max = n;
			}
			System.out.println("#"+i+" "+max);
		}
	}

}
