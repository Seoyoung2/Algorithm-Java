package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1863 : 종교
public class Main_1863 {
	static int N, M;
	static int[] parent, rank;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		rank = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		
		int a, b;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			unionSet(a, b);
		}
		
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if(i == parent[i])	cnt++;
		}
		System.out.println(cnt);
	}

	static int findSet(int a) {
		if(a == parent[a])	return a;
		return parent[a] = findSet(parent[a]);
	}
	static void unionSet(int a, int b) {
		int pa = findSet(a);
		int pb = findSet(b);
		if(pa != pb) {
			if(rank[pa] > rank[pb])	parent[pb] = pa;
			else{
				parent[pa] = pb;
				rank[pb]++;
			}
		}
	}
	
}
