package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 2564. 경비원
public class Main_2564 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<int[]> shop = new ArrayList<>(N);
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			// d : 1은 블록의 북쪽, 2는 블록의 남쪽, 3은 블록의 서쪽, 4는 블록의 동쪽에 상점이 있음
			// l : (d가 1,2) 블록의 왼쪽 경계로부터의 거리 / (d가 3,4) 블록의 위쪽 경계로부터의 거리
			shop.add(new int[] {d, l});
		}
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		for (int[] sh : shop) {
			if(x < 3) {
				if(x == sh[0]) {
					ans += Math.abs(y-sh[1]);
				} else if(sh[0] < 3){
					int tmp = y + sh[1];
					int tW = W > tmp ? tmp :  2 * W - tmp;
					ans += (H + tW);
				} else if(x == 1 && sh[0] == 3) {
					ans += (y + sh[1]);
				} else if(x == 1 && sh[0] == 4) {
					ans += (W-y+sh[1]);
				} else if(x == 2 && sh[0] == 3) {
					ans += (y+H-sh[1]);
				} else{
					ans += (W+H-y-sh[1]);
				}
			} else {
				if(x == sh[0]) {
					ans += Math.abs(y-sh[1]);
				} else if(sh[0] >= 3){
					int tmp = y + sh[1];
					int tH = H > tmp ? tmp :  2 * H - tmp;
					ans += (W + tH);
				} else if(x == 3 && sh[0] == 1) {
					ans += (y + sh[1]);
				} else if(x == 3 && sh[0] == 2) {
					ans += (H-y+sh[1]);
				} else if(x == 4 && sh[0] == 1) {
					ans += (y+W-sh[1]);
				} else{
					ans += (W+H-y-sh[1]);
				}
			}
		}
		System.out.println(ans);
	}
}
