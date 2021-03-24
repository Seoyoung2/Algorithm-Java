package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


// 1251. [S/W 문제해결 응용] 4일차 - 하나로
// 최소 신장 트리 (크루스칼), 범위가 커서 인접행렬보다는 인접리스트
public class Solution_1251_Kruskal {
	
	static class Edge implements Comparable<Edge>{
		int from, to;
		long cost;
		
		Edge(int from, int to, long cost){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.cost, o.cost);
		}
	}
	
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			long[] X = new long[N];
			long[] Y = new long[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				X[i] = Long.parseLong(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				Y[i] = Long.parseLong(st.nextToken());
			double E = Double.parseDouble(br.readLine());

			parents=new int[N];
			for (int i = 0; i < N; i++)	parents[i] = i;
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					long L = (X[i]-X[j])*(X[i]-X[j]) + (Y[i]-Y[j])*(Y[i]-Y[j]);
					pq.add(new Edge(i, j, L));
				}
			}
			
			long ans = 0;
			int cnt = 0;
			while(!pq.isEmpty()) {
				Edge e = pq.poll();
				if(union(e.from, e.to))	continue;
				ans += e.cost;
				if(++cnt == N-1)	break;
			}
			System.out.println("#"+tc+" "+Math.round(ans*E));
		}
	}
	
	static int find(int x){
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	static boolean union(int a,int b){
		int pa = find(a);
		int pb = find(b);
		if(pa != pb){ 
			parents[pb] = pa;
			return false;
		}
		return true;
	}

}

/*
#1 10000
#2 180000
#3 1125000
#4 1953913
#5 27365366
#6 337122
#7 711268755613
#8 280157
#9 521568761
#10 34
#11 375890356686
#12 68427157
#13 21404
#14 16620885
#15 4776395492
#16 54860981981
#17 24236206202
#18 132410
#19 12876964085
#20 7016649393
*/
