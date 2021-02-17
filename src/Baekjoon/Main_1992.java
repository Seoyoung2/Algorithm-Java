package Baekjoon;

import java.util.Scanner;

// 1992. 쿼드트리
public class Main_1992 {
	static int[][] scn;
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		scn = new int[N][N];
		for (int i = 0; i < N; i++) {
			String line = sc.next();
			for (int j = 0; j < N; j++) {
				scn[i][j] = line.charAt(j) - '0';
			}
		}
		
		divide(0, 0, N);
		System.out.println(sb.toString());
	}
	
	static void divide(int x, int y, int len) {
		if(check(x, y, len)) {
			sb.append(scn[x][y]);
		} else {
			sb.append("(");
			int next = len / 2;
			divide(x, y, next);
			divide(x, y+next, next);
			divide(x+next, y, next);
			divide(x+next, y+next, next);
			sb.append(")");
		}
	}
	
	static boolean check(int x, int y, int len) {
		int tmp = scn[x][y];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if(scn[x+i][y+j] != tmp)	return false;
			}
		}
		return true;
	}
}
