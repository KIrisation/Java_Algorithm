package baekjoon.workbook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/workbook/view/4349
 */
public class 평범한_배낭 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); // 최대 배낭 무게

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine());

            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            if (!map.containsKey(weight)) {
                map.put(weight, value);
            } else {
                if (map.get(weight) < value) { // 같은 무게가 들어올 경우 가치가 더 큰 값을 넣음.
                    map.put(weight, value);
                }
            }
        }

        int[] dp = new int[K + 1];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int weight = entry.getKey();
            int value = entry.getValue();

            for (int w = K; w >= weight; w--) {
                dp[w] = Math.max(dp[w], dp[w - weight] + value);
            }
        }

        writer.write(String.valueOf(dp[K]));
        writer.flush();
    }
}
