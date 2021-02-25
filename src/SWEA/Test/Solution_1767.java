package SWEA.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 1767. [SW Test 샘플문제] 프로세서 연결하기
public class Solution_1767 {
	static int N;
	static int[][] cell;
	static int min, max;
	static int[][] dxdy = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static List<int[]> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			cell = new int[N][N];
			
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cell[i][j] = Integer.parseInt(st.nextToken());
					if(cell[i][j]==1 && i>0 && i<N-1 && j>0 && j<N-1)	list.add(new int[] {i, j});
				}
			}
			min = Integer.MAX_VALUE;
			max = 0;
			connect(0, 0, 0);
			System.out.println("#" + tc + " " + min);
		}
	}

	static void connect(int idx, int core, int wire) {
		if(list.size()-idx+core < max)	return;
		if(idx == list.size()) {
			if(core > max) {
				max = core;
				min = wire;
			}
			if(core == max)	min = wire>min? min: wire;
			return;
		}
		
		// 코어 선택
		int x = list.get(idx)[0];
		int y = list.get(idx)[1];
		for (int i = 0; i < 4; i++) {
			if(isAvailable(x, y, i)) {
				int tmp = setCell(x, y, i, 2);
				connect(idx+1, core+1, wire+tmp);
				setCell(x, y, i, 0);
			}
		}
		
		// 코어 비선택
		connect(idx+1, core, wire);
	}
	
	static boolean isAvailable(int x, int y, int d) {
		int nx=x, ny=y;
		while(true) {
			nx += dxdy[d][0];
			ny += dxdy[d][1];
			if(nx<0 || nx>=N || ny<0 || ny>=N) return true;;
			if(cell[nx][ny] != 0) return false;
		}
	}

	static int setCell(int x, int y, int d, int s) {
		int cnt = 0;
		int nx = x, ny = y;
		while(true) {
			nx += dxdy[d][0];
			ny += dxdy[d][1];
			if(nx<0 || nx>=N || ny<0 || ny>=N)	break;
			cell[nx][ny] = s;
			cnt++;
		}
		return cnt;
	}
	
}
