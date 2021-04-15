package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2572 : 회전 초밥(중)
public class Main_2572 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 회전 초밥 벨트에 놓인 접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int[] table = new int[N];
        for (int i = 0; i < N; ++i) 
        	table[i] = Integer.parseInt(br.readLine());
        
        int[] chk = new int[d+1];
        chk[c]++;

        int cnt = 1;
        for (int i = 0; i < k; i++) {
        	if (chk[table[i]]++ == 0) cnt++;
        }
        int ans = cnt;

        for (int i = k; i < N + k; i++) {
            if(--chk[table[i-k]] == 0) cnt--;
            if(chk[table[i%N]]++ == 0) cnt++;
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
	}
}
