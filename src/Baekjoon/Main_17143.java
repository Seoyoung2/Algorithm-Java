package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 17143. 낚시왕
public class Main_17143 {
	static int R, C, M, ans, map[][];
	static List<Shark> list;
	static int[][] dxdy = {{}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	
	static class Shark {
		int  r, c, s, d, z;
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>(M);
        
        // (r, c)는 상어의 위치, s는 속력, d는 이동 방향, z는 크기
		int  r, c, s, d, z;
        for (int i = 1; i <= M; i++) {
        	st = new StringTokenizer(br.readLine());
        	r = Integer.parseInt(st.nextToken())-1;
        	c = Integer.parseInt(st.nextToken())-1;
        	s = Integer.parseInt(st.nextToken());
        	d = Integer.parseInt(st.nextToken());
        	z = Integer.parseInt(st.nextToken());
        	
        	// d : 상 하 우 좌 -> 상 좌 우 하
        	if(d == 2)	d = 4;
        	else if(d == 4)	d = 2;
        	
        	list.add(new Shark(r, c, s, d, z));
        	map[r][c] = i;
		}
        
        int king = -1;
        while(++king < C) {
        	attack(king);
        	move();
        }
        System.out.println(ans);
	}

	static void move() {
		int[][] tmp = new int[R][C];
		
		for (int i = 0; i < M; i++) {
			Shark sh = list.get(i);
			if(map[sh.r][sh.c] != i+1)	continue;

			int dist, nr = sh.r, nc = sh.c;
			if(sh.d == 1 || sh.d == 4)	dist = sh.s % ((R-1) * 2);
			else						dist = sh.s % ((C-1) * 2);
			
			for (int j = 0; j < dist; j++) {
				if(nr+dxdy[sh.d][0] < 0 || nr+dxdy[sh.d][0] >= R || nc+dxdy[sh.d][1] < 0 || nc+dxdy[sh.d][1] >= C) {
					sh.d = 5 - sh.d;
				}
				nr += dxdy[sh.d][0];
				nc += dxdy[sh.d][1];
			}
			sh.r = nr;	sh.c = nc;
			
			// 다른상어가 있고 나보다 크다면
			if(tmp[nr][nc] > 0 && sh.z < list.get(tmp[nr][nc]-1).z)	continue;
			tmp[nr][nc] = i+1;
		}
		map = tmp;
	}

	static void attack(int king) {
		for (int i = 0; i < R; i++) {
			if(map[i][king] > 0) {
				ans += list.get(map[i][king]-1).z;
				map[i][king] = 0;
				return;
			}
		}
	}
}
