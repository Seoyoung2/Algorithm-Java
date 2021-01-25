package SWEA.D2;

import java.util.Scanner;

// 1946. 간단한 압축 풀기
public class Solution_1946 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			char[][] arr = new char[2*n][10];
			int x = 0;
			int y = 0;
			for (int i = 0; i < n; i++) {
				char ch = sc.next().charAt(0);
				int cnt = sc.nextInt();
				for (int j = 0; j < cnt; j++) {
					arr[x][y++] = ch;
					if (y == 10) {
						x++;
						y = 0;
					}
				}
			}
			System.out.println("#" + tc);
			for (int i = 0; i <= x; i++) {
				for (int j = 0; j < 10; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
			
		}
		sc.close();
	}
}
