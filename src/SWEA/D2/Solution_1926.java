package SWEA.D2;

import java.util.Scanner;

// 1926. 간단한 369게임
public class Solution_1926 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			String s = Integer.toString(i);
			if (s.contains("3") || s.contains("6") || s.contains("9")) {
				s = s.replace("3", "-");
                s = s.replace("6", "-");
                s = s.replace("9", "-");
                s = s.replace("1", "");
                s = s.replace("2", "");
                s = s.replace("4", "");
                s = s.replace("5", "");
                s = s.replace("7", "");
                s = s.replace("8", "");
                s = s.replace("0", "");	
			}
			System.out.print(s + " ");
		}
		sc.close();
	}

}
