package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 12847. 꿀 아르바이트
public class Main_12847_1 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] T = new int[n+1];
        st = new StringTokenizer(br.readLine());
        long ans = 0, tmp = 0;
        for (int i = 1; i <= n; i++) {
			T[i] = Integer.parseInt(st.nextToken());
			tmp += T[i];
			if(i >= m) {
				tmp -= T[i-m];
				if(ans < tmp)	ans = tmp;
			}
		}
        System.out.println(ans);
	}
}
