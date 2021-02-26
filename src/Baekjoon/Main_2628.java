package Baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 2628. 종이자르기
public class Main_2628 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt();
		int H = sc.nextInt();
		int N = sc.nextInt();
		
		List<Integer> garo = new ArrayList<Integer>();
		List<Integer> sero = new ArrayList<Integer>();
		garo.add(0);
		garo.add(W);
		sero.add(0);
		sero.add(H);
		
		for (int i = 0; i < N; i++) {
			int wh = sc.nextInt();
			int idx = sc.nextInt();
			if(wh == 0)	sero.add(idx);
			else		garo.add(idx);
		}

		Collections.sort(garo);
		Collections.sort(sero);
		
		int ga=0, se=0;
		for (int i = 1; i < garo.size(); i++)
			ga = Math.max(ga, garo.get(i) - garo.get(i-1));
		for (int i = 1; i < sero.size(); i++) 
			se = Math.max(se, sero.get(i) - sero.get(i-1));
		System.out.println(ga*se);
	}
}
	


