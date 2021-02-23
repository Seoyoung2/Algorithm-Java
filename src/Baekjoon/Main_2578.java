package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2578. 빙고
public class Main_2578 {
	static int[][] board = new int[5][5];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int n;
		top:
		for (int i = 0; i < 25; i++) {
			if(i % 5 == 0)	st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					if(board[j][k] == n) {
						board[j][k] = 0;
						if(bingo()) {
							System.out.println(i+1);
							System.exit(0);
						}
						continue top;
					}
				}
			}
		}
	}
	
	static boolean bingo() {
		int sum1, sum2, sum3=0, sum4=0;
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			sum1 = sum2 = 0;
			for (int j = 0; j < 5; j++) {
				sum1 += board[i][j];
				sum2 += board[j][i];
			}
			if(sum1 == 0)	cnt++;
			if(sum2 == 0)	cnt++;

			sum3 += board[i][i];
			sum4 += board[i][4-i];
		}
		if(sum3 == 0)	cnt++;
		if(sum4 == 0)	cnt++;
		return cnt >= 3;
	}

	
}
