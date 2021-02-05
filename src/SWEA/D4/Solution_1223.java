package SWEA.D4;

import java.util.Scanner;
import java.util.Stack;

// 1223. [S/W 문제해결 기본] 6일차 - 계산기2
public class Solution_1223 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;
		Stack<Character> stk;
		
		for (int t = 1; t <= 10; t++) {
			int n = sc.nextInt();
			String str = sc.next();
			sb = new StringBuilder();

			stk = new Stack<>();
			char ch;
			for (int i = 0; i < n; i++) {
				ch = str.charAt(i);
				switch (ch) {
				case '*':
					while(!stk.isEmpty() && stk.peek() == '*')	sb.append(stk.pop());
					stk.push(ch);
					break;
				case '+':
					while(!stk.isEmpty())	sb.append(stk.pop());
					stk.push(ch);
					break;
				default:
					sb.append(ch);
					break;
				}
			}
			while(!stk.isEmpty())	sb.append(stk.pop());
			
			Stack<Integer> nstk = new Stack<>();
			int tmp;
			for (int i = 0; i < n; i++) {
				ch = sb.charAt(i);
				switch (ch) {
				case '*':
					tmp = nstk.pop() * nstk.pop();
					nstk.push(tmp);
					break;
				case '+':
					tmp = nstk.pop() + nstk.pop();
					nstk.push(tmp);
					break;
				default:
					nstk.push(ch-'0');
					break;
				}
			}
			System.out.println("#"+t+" "+nstk.pop());
		}
	}
}
