package Baekjoon;

import java.util.Scanner;

// 2477. 참외밭
public class Main_2477 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();

		int[] num = new int[6];
		int mx = 0, my = 0;
		for (int i = 0; i < 6; i++) {
			sc.nextInt();
			num[i] = sc.nextInt();
			if(i%2 == 0)	mx = Math.max(mx, num[i]);
			else			my = Math.max(my, num[i]);
		}
		
		int sx = 0, sy = 0;
		for (int i = 0; i < 6; i++) {
			if(i%2 == 0 && num[(i+5)%6]+num[(i+1)%6] == my)	sx = num[i];
			else if(i%2 == 1 && num[(i+5)%6]+num[(i+1)%6] == mx)	sy = num[i];
		}
		int tmp = (mx * my) - (sx * sy);
		System.out.println(tmp*K);
	}
}
