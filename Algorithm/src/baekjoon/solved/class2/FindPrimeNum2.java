package baekjoon.solved.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1978번: 소수 찾기
 */
public class FindPrimeNum2 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, cnt;
    public static void main(String[] args) {
        N = nextInt();

        boolean[] primeNumberCheck = new boolean[1001];

        Arrays.fill(primeNumberCheck, true);

        primeNumberCheck[0] = false;
        primeNumberCheck[1] = false;

        for (int i = 2; i * i <= 1000; i++) {
            if (!primeNumberCheck[i]) {
                continue;
            }

            for (int j = i + i; j <= 1000; j += i) {
                primeNumberCheck[j] = false; // 소수 아님.
            }
        }

        for (int i = 1; i <= N; i++) {
            if (primeNumberCheck[nextInt()]) {
                ++cnt;
            }
        }

        System.out.println(sb.append(cnt));
    }

    static String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
