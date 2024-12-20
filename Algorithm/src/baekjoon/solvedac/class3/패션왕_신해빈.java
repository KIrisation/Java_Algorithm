package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 전형적인 조합 문제임.
 */
public class 패션왕_신해빈 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        Map<String, Integer> clothes = new HashMap<>();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(reader.readLine()); // 의상수

            for (int j = 0; j < n; j++) {
                String kind = reader.readLine().split(" ")[1];

                if (clothes.containsKey(kind)) {
                    clothes.put(kind, clothes.get(kind) + 1);
                } else {
                    clothes.put(kind, 1);
                }
            }

            int sum = 1;
            for (Entry<String, Integer> entry : clothes.entrySet()) {
                sum *= (entry.getValue() + 1);
            }

            System.out.println(sum - 1);
            clothes.clear();
        }
    }
}
