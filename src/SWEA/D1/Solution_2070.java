package SWEA.D1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2070 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		String ans;
		
		for (int i = 1; i <= T; i++) {
			String str = br.readLine();
			st = new StringTokenizer(str);
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a>b) {
				ans = ">";
			} else if(a<b){
				ans = "<";
			} else {
				ans = "=";
			}
			System.out.println("#"+i+" "+ans);
		}
	}

}
