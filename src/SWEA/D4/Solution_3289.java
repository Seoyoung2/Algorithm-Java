package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3289. 서로소 집합
public class Solution_3289 {
	static int N, M;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb = new StringBuilder("#"+t+" ");
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			makeSet();
			
			int ord, a, b;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				ord = Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				if(ord == 0) {
					unionSet(a, b);
				}else {
					if(findSet(a) == findSet(b))	sb.append("1");
					else							sb.append("0");
				}
			}
			
			System.out.println(sb.toString());
		}
	}

	static void makeSet() {
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}

	static int findSet(int a) {
		if(a == parent[a])	return a;
		return parent[a] = findSet(parent[a]);
	}

	static void unionSet(int a, int b) {
		int pa = findSet(a);
		int pb = findSet(b);
		
		parent[pb] = pa;
	}
	
}
