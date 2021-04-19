package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 5607. [Professional] 조합
public class Solution_5607 {
	static final int MOD = 1234567891;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		long[] fact = new long[1000001];
		fact[0]=1;
		for(int i=1;i<1000001;i++) {
			fact[i] = (fact[i-1] * i) % MOD;
		}
		
		int T = Integer.parseInt(br.readLine());
		int N, R;
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			long up = 1, down = 1;
			up = fact[N];
			down = (fact[N-R]*fact[R])%MOD;
			down = exp(down, MOD-2);
			System.out.println("#"+t+" "+(up*down)%MOD);
		}
	}
	
	public static long exp(long x, long y) {
    	if (y == 1) return x;
    	long r = exp(x, y/2);
    	long result = (r * r) % MOD;
    	// 지수가 홀수일때 한번 더 곱해줌.
    	if (y % 2 == 0) return result;
    	else	return (result * x) % MOD;
    }
}
