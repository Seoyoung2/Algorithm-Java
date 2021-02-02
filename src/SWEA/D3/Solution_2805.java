package SWEA.D3;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//// 2805. 농작물 수확하기
//public class Solution_2805 {
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		
//		int T = Integer.parseInt(in.readLine());
//		for (int tc = 1; tc <= T; tc++) {
//			int n = Integer.parseInt(in.readLine());
//			int[][] farm = new int[n][n];
//			for (int i = 0; i < n; i++) {
//				String nums = in.readLine();
//				farm[i] = new int[n];
//				for (int j = 0; j < n; j++)
//					farm[i][j] = nums.charAt(j) - '0';
//			}
//			int cnt = 0;
//			int n2 = n/2;
//			for (int i = 0; i <= n2; i++) {
//				for (int j = 0; j <= n2-i; j++) {
//					if (farm[n2+i][n2+j] != 0) {
//						cnt += farm[n2+i][n2+j];
//						farm[n2+i][n2+j] = 0;
//					}
//					if (farm[n2-i][n2+j] != 0) {
//						cnt += farm[n2-i][n2+j];
//						farm[n2-i][n2+j] = 0;
//					}
//					if (farm[n2+i][n2-j] != 0) {
//						cnt += farm[n2+i][n2-j];
//						farm[n2+i][n2-j] = 0;
//					}
//					if (farm[n2-i][n2-j] != 0) {
//						cnt += farm[n2-i][n2-j];
//						farm[n2-i][n2-j] = 0;
//					}
//				}
//			}
//			System.out.println("#" + tc + " " + cnt);
//		}
//	}
//	
//}

import java.util.Scanner;

public class Solution_2805 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t=1; t<=tc; t++) {
            int n = sc.nextInt();
            int sum=0;
            for(int i=n/2; i>=0; i--) {
                String s = sc.next();
                for(int j=i; j<n-i; j++) {
                    sum += s.charAt(j)-'0';
                }
            }
            for(int i=1; i<=n/2; i++) {
                String s = sc.next();
                for(int j=i; j<n-i; j++) {
                    sum += s.charAt(j)-'0';
                }
            }
            System.out.println("#" + t + " " + sum);
        }
    }
 
}

