package SWEA.D1;

import java.util.Scanner;

// 2029. 몫과 나머지 출력하기
public class Solution_2029 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println("#" + i + " " + a/b + " " + a%b);
		}
		sc.close();
	}

}
