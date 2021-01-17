package SWEA;

import java.util.Scanner;

// 알파벳을 숫자로 변환 (2050)
public class Solution_2050 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		String ans = "";
		for (int i = 0; i < n.length(); i++) {
			ans += (n.charAt(i)-'A'+1) + " " ;
		}
		System.out.println(ans);
		sc.close();
	}

}
