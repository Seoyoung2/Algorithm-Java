package SWEA.D1;

import java.util.Scanner;

// 2043. 서랍의 비밀번호
public class Solution_2043 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		int k = sc.nextInt();
	
		System.out.println(p - k + 1);
		sc.close();
	}

}
