package baekjoon.solvedac.class2.twoplus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

/**
 * 해당 문제에서는 31^15까지 갈 수 있어서, 수가 매우 커질 수 있음 따라서 BIGINTEGER를 활용한 코드 작성이 없다면 반쪽짜리 정답 판정을 받음.
 */
public class Hashing {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(reader.readLine());
        String s = reader.readLine();
        int M = 1234567891;
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < L; i++) {
            int a = s.charAt(i) - 96;
            BigInteger r = new BigInteger(String.valueOf(1));

            for (int j = i; j > 0; j--) {
                r = r.multiply(new BigInteger(String.valueOf(31)));
            }

            sum = sum.add(r.multiply(new BigInteger(String.valueOf(a))));
        }

        writer.write(String.valueOf(sum.mod(new BigInteger(String.valueOf(M)))));
        writer.flush();
    }
}
