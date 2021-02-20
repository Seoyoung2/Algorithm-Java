package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


// 1325. 효율적인 해킹
public class Main_1325 {
	static int N, M;
	static LinkedList<Integer> depend[];;
	static boolean[] check;
	static int[] hack;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		depend = new LinkedList[N+1];
		for (int i = 1; i <= N; i++) {
			depend[i] = new LinkedList<>();
		}
		
		int A, B;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			depend[A].add(B);	// A가 B를 신뢰한다
		}

		// dfs
		hack = new int[N+1];
		for (int i = 1; i <= N; i++) {
			check = new boolean[N+1];
			dfs(i);
		}

		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, hack[i]);
		}
		for (int i = 1; i <= N; i++) {
			if(hack[i] == max) {
				System.out.print(i+" ");
			}
		}
	}
	
	static void dfs(int idx) {
		check[idx] = true;
		for (int i=0, end=depend[idx].size(); i < end; i++) {
			int tmp = depend[idx].get(i);
			if(!check[tmp]) {
				hack[tmp]++;
				dfs(tmp);
			}
		}
	}
} 