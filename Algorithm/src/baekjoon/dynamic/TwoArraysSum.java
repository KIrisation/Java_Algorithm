package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 백준 2164번: 두 배열의 합
 */
public class TwoArraysSum {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int T;
    static int[] A;
    static List<Integer> ASum = new ArrayList<>();
    static int[] B;
    static List<Integer> BSum = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();

        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = i; j < A.length; j++) {
                sum += A[j];
                ASum.add(sum);
            }
        }

        for (int i = 0; i < B.length; i++) {
            int sum = 0;
            for (int j = i; j < B.length; j++) {
                sum += B[j];
                BSum.add(sum);
            }
        }

        Collections.sort(ASum);
        Collections.sort(BSum);

        writer.write(getCount() + "\n");
        writer.flush();
    }

    public static long getCount() {
        int pointerA = 0;
        int pointerB = BSum.size() - 1;
        long cnt = 0;

        while (pointerA < ASum.size() && pointerB >= 0) {
            long sum = ASum.get(pointerA) + BSum.get(pointerB);

            if (sum == T) {
                int a = ASum.get(pointerA);
                int b = BSum.get(pointerB);

                long aCnt = 0;
                long bCnt = 0;

                while (pointerA < ASum.size() && ASum.get(pointerA) == a) {
                    aCnt++;
                    pointerA++;
                }

                while (pointerB >= 0 && BSum.get(pointerB) == b) {
                    bCnt++;
                    pointerB--;
                }

                cnt += aCnt * bCnt;
            } else if (sum < T) {
                pointerA++;
            } else if (sum > T) {
                pointerB--;
            }
        }

        return cnt;
    }

    private static void input() throws IOException {
        T = Integer.parseInt(reader.readLine());

        A = new int[Integer.parseInt(reader.readLine())];
        A = Arrays.stream(reader.readLine().split(" "))
                  .mapToInt(Integer::parseInt)
                  .toArray();

        B = new int[Integer.parseInt(reader.readLine())];
        B = Arrays.stream(reader.readLine().split(" "))
                  .mapToInt(Integer::parseInt)
                  .toArray();
    }
}
