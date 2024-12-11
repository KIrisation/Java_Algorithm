package baekjoon.solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팩토리얼_0의_개수 {

    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        factorial(N);

        System.out.println(cnt);
    }

    public static void factorial(int N) {
        if (N >= 5) {
            cnt += N / 5;
            N /= 5;

            factorial(N);
        }
    }
}
