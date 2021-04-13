package SWEA.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 4014. [모의 SW 역량테스트] 활주로 건설
public class Solution_4014 {
	static int N,X,land[][],tland[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			land = new int[N][N];
			tland = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					tland[j][i] = land[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ans = 0;
			for (int i = 0; i < N; i++) {
				if(makeRoad(land[i])) ++ans;
				if(makeRoad(tland[i])) ++ans;
			}
			System.out.println("#"+t+" "+ans);
		}
	}
	
	// 코드 중복을 피하기 위해 매개변수로 인덱스 대신 일차원 함수의 참조값 주기
	static boolean makeRoad(int[] road) {
		int prev = road[0];
		int size = 0;
		
		int j = 0; 
		while(j<N) {
			if(prev==road[j]) {
				++size;
				++j;
			}else if(prev+1==road[j]) { 
				if(size<X) return false;
				prev++;
				size = 1;
				++j;
			}else if(prev-1==road[j]) {
				int count = 0;
				for (int k = j; k <N; k++) {
					if(road[k] != prev-1) break;
					if(++count==X) break;
				}
				if(count<X) return false;
				prev--;
				size = 0;
				j += X;
			}else {
				return false;
			}
		}
		return true;
	}
}








