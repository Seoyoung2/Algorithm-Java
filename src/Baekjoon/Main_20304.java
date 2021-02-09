package Baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20304 {
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// password, security
		Queue<int[]> pwd = new LinkedList<int[]>();
		for (int i = 0; i < M; i++) {
			pwd.offer(new int[] {Integer.parseInt(st.nextToken()), 0});
		}

		int ans = 0;
		int[] cur = new int[2];
		boolean[] visit = new boolean[N+1];
		while(!pwd.isEmpty()) {
			cur = pwd.poll();
			ans = Math.max(ans, cur[1]);
			
			for (int i = 1; i <= N; i = i<<1) {
				int diff = cur[0] & i;
				int cnt;
				
				if(diff <= 0)	cnt = i + cur[0];
				else			cnt = cur[0] - i;
				if(cnt > N || visit[cnt])	continue;
				visit[cnt] = true;
				pwd.offer(new int[] {cnt, cur[1]+1});
			}
		}
		System.out.println(ans);
	}
}
