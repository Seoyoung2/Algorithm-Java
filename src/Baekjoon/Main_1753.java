package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 1753. 최단경로 (인접행렬 말고 인접리스트로 풀 수 있음)
public class Main_1753 {

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		LinkedList<int[]>[] list = new LinkedList[V+1];
		int[] D = new int[V+1];
		boolean[] visit = new boolean[V+1];
		for (int i = 1; i <= V; i++) {
			list[i] = new LinkedList<>();
			D[i] = Integer.MAX_VALUE;
		}
		D[K] = 0;
		
		int u, v, w;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			list[u].add(new int[] {v, w});
		}
		
		int min, cur=0;
		for (int i = 1; i <= V; i++) {
			min = Integer.MAX_VALUE;
			for (int j = 1; j <= V; j++) {
				if(!visit[j] && D[j] < min) {
					min = D[j];
					cur = j;
				}
			}
			visit[cur] = true;
			for (int[] next : list[cur]) {
				if(!visit[next[0]] && min+next[1] < D[next[0]]) {
					D[next[0]] = min + next[1];
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			if(D[i] == Integer.MAX_VALUE)	System.out.println("INF");
			else							System.out.println(D[i]);
		}
	}
}
