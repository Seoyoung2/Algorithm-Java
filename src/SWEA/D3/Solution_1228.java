package SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 1228. 암호문1
public class Solution_1228 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		LinkedList<Integer> ll;
		
		for (int t = 1; t <= 10; t++) {
			ll = new LinkedList<>();
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				ll.add(Integer.parseInt(st.nextToken()));
			}
			
			int ord = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < ord; i++) {
				st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				for (int j = 0; j < y; j++) {
					if(x>10) {
						st.nextToken();
						continue;
					}
					ll.add(x++, Integer.parseInt(st.nextToken()));
				}
			}
			System.out.print("#"+t);
			for (int i = 0; i < 10; i++) {
				System.out.print(" "+ll.poll());
			}
			System.out.println();
		}
	}
}
