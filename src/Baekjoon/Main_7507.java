package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 7507. 올림픽 게임 
public class Main_7507 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int m, d, s, e;	//d는 경기의 날짜, s는 시작 시간, e는 종료 시간 (시간은 hhmm형식)
        for (int i = 1; i <= n; i++) {
        	m = Integer.parseInt(br.readLine());
        	ArrayList<int[]> list = new ArrayList<>();
        	
        	for (int j = 0; j < m; j++) {
    			st = new StringTokenizer(br.readLine());
    			d = Integer.parseInt(st.nextToken());
    			s = Integer.parseInt(st.nextToken());
    			e = Integer.parseInt(st.nextToken());
    			list.add(new int[] {d, s, e});
			}
        	
			Collections.sort(list, (x, y) -> {
				if(x[0] == y[0]) {
					if(x[2] == y[2])	return x[1] - y[1];
					return x[2] - y[2];
				}
				return x[0] - y[0];
			});
			
        	int ans = 1;
        	int today = list.get(0)[0];
        	int end = list.get(0)[2];
        	int[] tmp;
        	for (int j = 1; j < m; j++) {
        		tmp = list.get(j);
				if(today < tmp[0] || end <= tmp[1]) {
					ans++;
					today = tmp[0];
					end = tmp[2];
				}
			}
        	bw.write("Scenario #"+i+":\n");
        	bw.write(ans+"\n\n");
		}
        bw.flush();
		bw.close();
	}
}
