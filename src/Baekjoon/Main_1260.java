package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1260. DFS와 BFS 
public class Main_1260 {
	static LinkedList<Integer>[] list;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken()) - 1;
		
		list = new LinkedList[N];
		for (int i = 0; i < N; i++)
			list[i] = new LinkedList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			list[a].add(b);
			list[b].add(a);
		}
		for (int i = 0; i < N; i++)
			Collections.sort(list[i]);;
		
		visit = new boolean[N];
		dfs(V);
		sb.append("\n");
		visit = new boolean[N];
		bfs(V);
		
		System.out.println(sb.toString());
	}

	static void dfs(int v) {
		visit[v] = true;
		sb.append((v+1) + " ");

		for (Integer n : list[v]) {
			if(!visit[n]) {
				visit[n] = true;
				dfs(n);
			}
		}
	}

	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		visit[v] = true;
		q.offer(v);

		while(!q.isEmpty()) {
			int x = q.poll();
			sb.append((x+1) + " ");
			for (Integer n : list[x]) {
				if(!visit[n]) {
					visit[n] = true;
					q.offer(n);
				}
			}
		}
	}
}
