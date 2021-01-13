package Jungol;

import java.util.Scanner;

public class 선택제어문_529 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int weight = sc.nextInt();
        int ans = weight + 100 - height;
        System.out.println(ans);
        if (ans > 0) {
            System.out.println("Obesity");
        } 
    }
}
