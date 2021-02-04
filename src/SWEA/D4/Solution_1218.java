package SWEA.D4;

import java.util.Scanner;
import java.util.Stack;

// 1218. [S/W 문제해결 기본] 4일차 - 괄호 짝짓기
public class Solution_1218 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int n = sc.nextInt();
			String str = sc.next();

			Stack<Character> stk = new Stack<>();
			stk.add(str.charAt(0));
			
			int ans = 1, i = 1;
			Character x, y;
			while(!stk.isEmpty()) {
				x = str.charAt(i++);
				if(x == '(' || x == '[' || x == '<' || x == '{') {
					stk.add(x);
					continue;
				}
				y = stk.peek();
				if((x==')'&&y=='(') || (x==']'&&y=='[') || (x=='>'&&y=='<') || (x=='}'&&y=='{')) {
					stk.pop();
					continue;
				}
				ans = 0;
				break;
			}
			System.out.println("#"+t+" "+ans);
		}
	}
}
