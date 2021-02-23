package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 2309. 일곱 난쟁이
public class Main_2309 {
	static int[] ans = new int[7];
	static int[] height = new int[9];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++)
			height[i] = Integer.parseInt(br.readLine());
		
		combi(0, 0, 0);
	}

	static void combi(int idx, int start, int sum) {
		if(sum > 100)	return;
		if(idx == 7) {
			if(sum == 100) {
				Arrays.sort(ans);
				for (int i : ans)
					System.out.println(i);
				System.exit(0);
			}
			return;
		}
		
		for (int i = start; i < 9; i++) {
			ans[idx] = height[i];
			combi(idx+1, i+1, sum+height[i]);
		}
	}
}
