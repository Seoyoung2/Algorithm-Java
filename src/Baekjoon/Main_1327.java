package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// 1327. 소트 게임 
public class Main_1327 {
	static int N, K, num[], goal[];
	static Set<Node> visit = new HashSet<>();
	
	static class Node {
		int now[];
		Node(int[] now) {
			this.now = now;
		}

		@Override
		public int hashCode() {
			//return now.hashCode();
			return Arrays.hashCode(now);
		}
		@Override
		public boolean equals(Object obj) {
			return obj.hashCode() == this.hashCode();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        num = new int[N];
        goal = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
			num[i] = goal[i] = Integer.parseInt(st.nextToken());
		}
        Arrays.sort(goal);
        
        if(endGame(num))	System.out.println(0);
        else				System.out.println(bfs());
	}

	static int bfs() {
		Queue<Node> q = new LinkedList<>();
		Node first = new Node(num);
		q.offer(first);
		visit.add(first);
		
		int size, res=0;
		Node no, node;
		while(!q.isEmpty()) {
			res++;
			size = q.size();
			while(size-- > 0) {
				no = q.poll();
				for (int i = 0; i <= N-K; i++) {
					node = new Node(revert(no.now, i));
					if(visit.contains(node))	continue;
					if(endGame(node.now))	return res;
					q.offer(node);
					visit.add(node);
				}
			}
		}
		return -1;
	}

	static boolean endGame(int[] next) {
		for (int i = 0; i < N; i++) {
			if(goal[i] != next[i])	return false;
		}
		return true;
	}

	// arr배열에서 l부터 l+K까지의 서브배열을 뒤집기
	static int[] revert(int[] tarr, int l) {
		int[] arr = tarr.clone();
		int r = l+K-1;
		for(int i=0, d=K/2; i<d; i++){
		   int t = arr[l+i];
		   arr[l+i] = arr[r-i];
		   arr[r-i] = t;
		}
		return arr;
	}
}
