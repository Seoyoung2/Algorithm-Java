package Baekjoon;

import java.util.Scanner;

// 15649. N과 M (1)
public class Main_15649 {
	static int n, m;
	static int[] num;
	//static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		num = new int[m];
		//isSelected = new boolean[n+1];
		//select(0);
		select2(0,0);
	}
	
//	static void select(int idx) {
//		if(idx == m) {
//			for (int n : num) {
//				System.out.print(n+" ");
//			}
//			System.out.println();
//			return;
//		}
//		for (int i = 1; i <= n; i++) {
//			if(isSelected[i]) continue;
//			num[idx] = i;
//			isSelected[i] = true;
//			select(idx+1);
//			isSelected[i] = false;
//		}
//	}
	
	static void select2(int idx, int flag) {
		if(idx == m) {
			for (int n : num) {
				System.out.print(n+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= n; i++) {
			if((flag & 1<<i) != 0)	continue;
			num[idx] = i;
			select2(idx+1, flag | 1<<i);
		}
		
	}
}
