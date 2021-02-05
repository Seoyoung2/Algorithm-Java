package SWEA.D3;

import java.util.Scanner;

// 3499. 퍼펙트 셔플
public class Solution_3499 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			
			String[] card = new String[n];
			for (int i = 0; i < n; i++)
				card[i] = sc.next();
			
			System.out.print("#"+t+" ");
			if(n%2 == 0) {
				for (int i = 0; i < n/2; i++)
					System.out.print(card[i]+" "+card[n/2+i]+" ");
			}else {
				for (int i = 0; i < n/2; i++)
					System.out.print(card[i]+" "+card[n/2+i+1]+" ");
				System.out.print(card[n/2]);
			}
			System.out.println();
		}
	}
	
	
}
