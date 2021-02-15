package SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 6808. 규영이와 인영이의 카드게임
public class Solution_6808 {
	static int[] my = new int[9];
	static int[] your = new int[9];
	static int[] card = new int[9];
	static int win, lose;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++)
				my[i] = Integer.parseInt(st.nextToken());
			
			top:
			for (int i = 1, idx = 0; i <= 18; i++) {
				for (int j = 0; j < 9; j++)
					if(i == my[j])	continue top;
				your[idx++] = i;
			}
			
			win = 0; lose = 0;
			play(0, 0);
			System.out.println("#" + tc + " " + win + " " + lose);
		}
	} 
	
	static void play(int idx, int flag) {
		if(idx == 9) {
			int s1 = 0, s2 = 0;
			for (int i = 0; i < 9; i++) {
				if(my[i] > card[i])	s1 += (my[i]+card[i]);
				else	s2 += (my[i]+card[i]);
			}
			if(s1>s2)	win++;
			else		lose++;
			return;
		}
		for (int i = 1; i <= 9; i++) {
			if((flag & 1<<i) != 0)	continue;
			card[idx] = your[i-1];
			play(idx+1, flag | 1<<i);
		}
	}
}
