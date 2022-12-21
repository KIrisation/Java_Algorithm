package baekjoon.solved.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 백준 2920번: 음계
 */
public class Scale {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<String, String> result = new HashMap<>();
    static String scale = "";

    public static void main(String[] args) throws IOException {
        input();
        initTypeOfScale();
        output(typeOfScale());
    }

    private static void input() throws IOException {
        scale = br.readLine();
    }

    private static void initTypeOfScale() {
        result.put("1 2 3 4 5 6 7 8", "ascending");
        result.put("8 7 6 5 4 3 2 1", "descending");
    }

    private static String typeOfScale() {
        return result.getOrDefault(scale, "mixed");
    }

    private static void output(String typeOfScale) {
        System.out.println(typeOfScale);
    }
}
