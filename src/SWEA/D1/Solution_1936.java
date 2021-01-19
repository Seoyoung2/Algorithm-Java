package SWEA.D1;

import java.util.Scanner;

// 1대1 가위바위보 (1936)
public class Solution_1936 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 가위는 1, 바위는 2, 보는 3으로 표현
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if ((a==1 && b==3) || (a==2 && b==1) || (a==3 && b==2)) {
			System.out.println("A");
		} else {
			System.out.println("B");
		}
		sc.close();
	}

}
