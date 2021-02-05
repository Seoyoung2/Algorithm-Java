package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1141 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stk = new Stack<>();

		long ans =0;
		int x=0;
		for (int i = 0; i < n; i++) {
			// x"가" 볼 수 있는 소가 아니라 x"를" 볼 수 있는 소의 개수를 셈
			x = Integer.parseInt(br.readLine());
			
			// x보다 작은 소들을 스택에서 제거
			while (!stk.isEmpty() && stk.peek() <= x) {
				stk.pop();
			}
			// 스택에 남은 소들은 모드 x를 볼 수 있는 소
			ans += stk.size();
			stk.push(x);
		}
		System.out.println(ans);
	}

}
