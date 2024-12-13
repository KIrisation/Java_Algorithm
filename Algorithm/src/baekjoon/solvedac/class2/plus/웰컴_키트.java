package baekjoon.solvedac.class2.plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 웰컴_키트 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] clothes = new int[6];
        String[] s = reader.readLine().split(" ");
        for (int i = 0; i < 6; i++) {
            clothes[i] = Integer.parseInt(s[i]);

        }

        String[] s1 = reader.readLine().split(" ");
        int T = Integer.parseInt(s1[0]);
        int P = Integer.parseInt(s1[1]);

        int tCnt = 0;
        for (int i = 0; i < clothes.length; i++) {
            if (clothes[i] % T == 0) {
                tCnt += clothes[i] / T;
            } else {
                tCnt += clothes[i] / T + 1;
            }
        }

        System.out.println(tCnt);
        System.out.println((N / P) + " " + (N % P));
    }
}
