package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


// 1251. [S/W 문제해결 응용] 4일차 - 하나로
// 최소 신장 트리 (프림), 범위가 커서 인접행렬보다는 인접리스트
public class Solution_1251_Prim {

	static class Edge implements Comparable<Edge>{
		int to;
		long cost;
		Edge(int to, long cost){
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.cost, o.cost);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			long[] X = new long[N];
			long[] Y = new long[N];
			boolean[] visit = new boolean[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				X[i] = Long.parseLong(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				Y[i] = Long.parseLong(st.nextToken());
			double E = Double.parseDouble(br.readLine());

			// 가능한 모든 간선의 비용을 저장
			LinkedList<Edge>[] list = new LinkedList[N];
			for (int i = 0; i < N; i++) {
				list[i] = new LinkedList<>();
				for (int j = 0; j < N; j++) {
					if(i == j)	continue;
					long L = (X[i]-X[j])*(X[i]-X[j]) + (Y[i]-Y[j])*(Y[i]-Y[j]);
					list[i].add(new Edge(j, L));
				}
			}
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.add(new Edge(0, 0));
			long ans = 0;
			int cnt = 0;
			while(!pq.isEmpty()) {
				Edge e = pq.poll();
				if(visit[e.to])	continue;
				visit[e.to] = true;
				ans += e.cost;
				if(++cnt == N)	break;
				
				for (Edge edge : list[e.to]) {
					if(!visit[edge.to])	pq.add(edge);
				}
			}
			
			System.out.println("#"+tc+" "+Math.round(ans*E));

		}
	}
}
