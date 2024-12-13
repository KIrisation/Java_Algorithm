package baekjoon.solvedac.class2.plus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 이항계수1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = reader.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        writer.write(String.valueOf(factorial(N) / (factorial(M) * factorial(N - M))));
        writer.flush();
    }

    public static int factorial(int N) {
        if(N == 0) {
            return 1;
        }
        return N * factorial(N - 1);
    }
}
