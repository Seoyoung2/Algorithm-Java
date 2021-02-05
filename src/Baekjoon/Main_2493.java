package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 탑 (Gold5)
public class Main_2493 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Stack<int[]> stk = new Stack<>();
		
		int x;
		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(st.nextToken());
			
			while (!stk.isEmpty() && stk.peek()[1] < x) {
				stk.pop();
			}
			if(stk.isEmpty())	System.out.print(0+" ");
			else				System.out.print(stk.peek()[0]+" ");
			stk.push(new int[] {i+1, x});

		}
	}
}
