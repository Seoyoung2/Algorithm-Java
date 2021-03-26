package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 17070. 파이프 옮기기 1
// dp 사용하지 않은 풀이 : LinkedList 쓰면 시간초과, ArrayList 썼더니 통과
public class Main_17070 {
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)	map[i][j] = Integer.parseInt(st.nextToken());
		}
        
        ArrayList<int[]> pipe = new ArrayList<>();
        pipe.add(new int[] {0, 1, 0});
        // 0: right, 1:down, 2:right-down
        
        int cnt = 0;
        int[] cur = new int[3];
        while(!pipe.isEmpty()) {
        	cur = pipe.remove(0);
        	if(cur[0] == N-1 && cur[1] == N-1) {
        		cnt++;
        		continue;
        	}
        	int nx, ny;
        	if(cur[2] != 1) {
        		nx = cur[0]; ny = cur[1]+1;
        		if(inRange(nx, ny, N)) {
            		pipe.add(new int[] {nx, ny, 0});
        		}
        	}
        	if(cur[2] != 0) {
        		nx = cur[0]+1; ny = cur[1];
        		if(inRange(nx, ny, N)) {
            		pipe.add(new int[] {nx, ny, 1});
        		}
        	}
        	nx = cur[0]+1; ny = cur[1]+1;
        	if(inRange(nx, ny, N) && map[nx-1][ny]==0 && map[nx][ny-1]==0) {
        		pipe.add(new int[] {nx, ny, 2});
    		}
        }
        System.out.println(cnt);
	}
	
	static boolean inRange(int x, int y, int N) {
		if(x<0 || x>=N || y<0 || y>=N || map[x][y] != 0)	return false;
		return true;
	}
}
