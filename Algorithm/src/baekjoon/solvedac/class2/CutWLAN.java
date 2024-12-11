package baekjoon.solvedac.class2;

import java.util.Scanner;

/**
 * 백준 1654번: 랜선 자르기
 */
public class CutWLAN {

    static int k;
    static int n;
    static int[] wlans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        n = sc.nextInt();

        wlans = new int[k];

        long min = 1;
        long max = 1;

        for (int i = 0; i < k; ++i) {
            wlans[i] = sc.nextInt();

            max = Math.max(max, wlans[i]);
        }

        while (min <= max) {
            int cnt = 0;
            long target = (min + max) / 2;

            for (int lan : wlans) {
                cnt += lan / target;
            }

            if (cnt >= n) {
                min = target + 1;
            } else {
                max = target - 1;
            }
        }
        System.out.println(max);
    }
}
