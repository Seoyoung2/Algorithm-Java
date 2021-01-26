package SWEA.D2;

import java.util.Scanner;

// 1288. 새로운 불면증 치료법
public class Solution_1288 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int n = sc.nextInt();
			boolean[] num = new boolean[10];
			
			int idx = 1;
			String tmp = "";
			boolean flag = true;
			while(true) {
				tmp = Integer.toString(n * idx++);
				for (int j = 0; j < tmp.length() ; j++)
					num[tmp.charAt(j)-'0'] = true;
				for (int j = 0; j < 10; j++) {
					if (num[j] == false) {
						flag = false;
						break;
					}
				}
				if (flag) break;
				flag = true;
			}
			System.out.println("#" + i + " " + n*(idx-1));
		}
		
	}

}
