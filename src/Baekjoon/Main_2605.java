package Baekjoon;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

// 2605. 줄 세우기
public class Main_2605 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		LinkedList<Integer> list = new LinkedList<>();
		int n;
		for (int i = 1; i <= N; i++) {
			n = sc.nextInt();
			list.add(n, i);
		}
		Collections.reverse(list);
		
		for (Integer in : list)
			System.out.print(in+" ");
	
	}
}
