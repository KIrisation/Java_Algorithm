package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 동전_0 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = reader.readLine().split(" ");
        int N = Integer.parseInt(s[0]); // 동전 갯수
        int M = Integer.parseInt(s[1]); // 타겟 머니

        int[] type = new int[N];
        for (int i = 0; i < N; i++) {
            type[i] = Integer.parseInt(reader.readLine());
        }

        // Arrays.sort(type); 이미 오름차순으로 정렬된 값을 준다라고 되어있음.

        int coinCnt = 0;
        while (N > 0) {
            N -= 1;
            int currentMoney = type[N];

            if (M % currentMoney != M) {
                coinCnt += M / currentMoney;
                M %= currentMoney;
            }
        }

        writer.write(String.valueOf(coinCnt));
        writer.newLine();
        writer.flush();
    }
}
