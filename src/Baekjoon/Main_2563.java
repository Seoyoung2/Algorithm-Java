package Baekjoon;

import java.util.Scanner;

// 2563. 색종이
public class Main_2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[][] board = new boolean[100][100];
		int cnt = 0;
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int j = 0; j < 10; j++)
				for (int j2 = 0; j2 < 10; j2++)
					if(!board[x+j][y+j2]) {
						board[x+j][y+j2] = true;
						cnt++;
					}
		}
		System.out.println(cnt);
	}
}
