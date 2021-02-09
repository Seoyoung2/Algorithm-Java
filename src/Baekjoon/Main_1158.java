package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 1158. 요세푸스 문제
public class Main_1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder("<");
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < N; i++)
			q.offer(i+1);		
		
		int x, cnt = 1;
		while(!q.isEmpty()) {
			x = q.poll();
			if(cnt++ % K == 0)	sb.append(x+", ");
			else 				q.offer(x);
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb.toString());
	}
	
}
