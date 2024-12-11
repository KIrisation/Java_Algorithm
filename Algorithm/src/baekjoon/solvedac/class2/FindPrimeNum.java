package baekjoon.solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class FindPrimeNum {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int M, N;
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) {
        M = nextInt();
        N = nextInt();

        boolean[] primeNumberCheck = new boolean[N + 1];

        Arrays.fill(primeNumberCheck, true);

        primeNumberCheck[0] = false;
        primeNumberCheck[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (!primeNumberCheck[i]) {
                continue;
            }

            for (int j = i + i; j <= N; j += i) {
                primeNumberCheck[j] = false; // 소수 아님.
            }
        }

        for (int i = M; i < primeNumberCheck.length; i++) {
            if (primeNumberCheck[i]) {
                result.add(i);
            }
        }

        for (Integer integer : result) {
            System.out.println(integer);
        }
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
