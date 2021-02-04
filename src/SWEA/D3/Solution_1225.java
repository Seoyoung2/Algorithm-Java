package SWEA.D3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 1225. [S/W 문제해결 기본] 7일차 - 암호생성기
public class Solution_1225 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int n = sc.nextInt();
			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < 8; i++)
				q.add(sc.nextInt());

			int x;
			top:
			while(true) {
				for (int i = 1; i < 6; i++) {
					x = q.poll() - i;
					if(x <= 0) {
						q.add(0);
						break top;
					}
					q.add(x);
				}
			}
			System.out.print("#"+t);
			for (int i : q)
				System.out.print(" "+i);
			System.out.println();
		}
	}
}
