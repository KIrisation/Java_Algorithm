package programmers.lv0.day1_9;

import java.util.Scanner;

public class RightIsoscelesTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        String star = "*";
        for (int i = 1; i <= n; i++) {
            System.out.println(star.repeat(i));
        }
    }

    public static void solution2(int n) {
        String star = "*";
        for (int i = 1; i <= n; i++) {
            System.out.println(star.repeat(i));
        }
    }
}
