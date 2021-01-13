package Jungol;

import java.util.Scanner;

public class 반복제어문1_539 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i = 0;
		int sum = 0;
		while(true) {
			i++;
			int n = sc.nextInt();
			sum += n;
			if(n>=100)	break;
		}
		
		System.out.println(sum);
		System.out.printf("%.1f", sum/(double)i);
	}

}
