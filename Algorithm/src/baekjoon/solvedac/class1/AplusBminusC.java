package baekjoon.solvedac.class1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * https://www.acmicpc.net/problem/31403
 */
public class AplusBminusC {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(reader.readLine());
        int B = Integer.parseInt(reader.readLine());
        int C = Integer.parseInt(reader.readLine());

        String sA = String.valueOf(A);
        String sB = String.valueOf(B);

        writer.write(String.valueOf(A + B - C));
        writer.newLine();
        writer.write(String.valueOf(Integer.parseInt(sA + sB) - C));
        writer.flush();
    }
}
