package Jungol;

import java.util.Scanner;

public class 반복제어문1_538 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("number? ");
			int n = sc.nextInt();
			if (n == 0) {
				break;
			} else if (n > 0) {
				System.out.println("positive integer");
			} else {
				System.out.println("negative number");
			}
		}
	}

}
