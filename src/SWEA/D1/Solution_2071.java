package SWEA.D1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_2071 {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0;
        int T = Integer.parseInt(br.readLine());
        for(int i = 1; i <= T; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            while(st.hasMoreTokens()) {
                int temp = Integer.parseInt(st.nextToken());
                sum += temp;
            }
            System.out.println("#" + i + " " + Math.round(sum/10));
            sum = 0.0;
        }
    }
 
}