package Baekjoon;

import java.util.Scanner;

// 20001. 고무오리 디버깅 
public class Main_20001 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		String str = sc.nextLine();
		
		int cnt = 0;
		while(!str.equals("고무오리 디버깅 끝")) {
			if(str.equals("문제"))	cnt++;
			else {
				if(cnt-1 < 0)	cnt+=2;
				else			cnt--;
			}
			str = sc.nextLine();
		}
		if(cnt == 0)
			System.out.println("고무오리야 사랑해");
		else
			System.out.println("힝구");
	}
}
