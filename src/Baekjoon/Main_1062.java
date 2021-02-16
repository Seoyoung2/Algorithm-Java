package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


// 1062. 가르침
public class Main_1062 {
	static int N, K;
	static boolean[] learn = new boolean[26];
	static String[] words;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		learn['a'-'a'] = learn['n'-'a'] = learn['t'-'a'] = learn['i'-'a'] = learn['c'-'a'] = true;
		
		words = new String[N];
		List<Character> candi = new LinkedList<Character>();
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine().replaceAll("anta|tica", "");
		}
		
		if(K < 5) {
			System.out.println(0);
			return;
		}

		combi(0, 0);
		System.out.println(ans);
	}
	
	static void combi(int idx, int start) {
		if(idx == K-5) {
			int cnt = 0;
			out:
			for (int i = 0; i < N; i++) {
				String tmp = words[i];
				for (int j = 0; j < tmp.length(); j++) {
					char w = tmp.charAt(j);
					if(!learn[w-'a'])	continue out;
				}
				cnt++;
			}
			ans = Math.max(ans, cnt);
			return;
		}
		for (int i = start; i < 26; i++) {
			if(learn[i])	continue;
			learn[i] = true;
			combi(idx+1, i+1);
			learn[i] = false;
		}
	}
}
