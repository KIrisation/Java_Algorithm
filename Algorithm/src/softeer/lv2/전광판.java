package softeer.lv2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 전광판 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static Map<String, String> numbers = new HashMap<>();
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(reader.readLine());

        numbers.put(" ", "0000000");
        numbers.put("0", "1110111");
        numbers.put("1", "0010010");
        numbers.put("2", "1011101");
        numbers.put("3", "1011011");
        numbers.put("4", "0111010");
        numbers.put("5", "1010111");
        numbers.put("6", "1101111");
        numbers.put("7", "1110010");
        numbers.put("8", "1111111");
        numbers.put("9", "1111011");

        int T = Integer.parseInt(st.nextToken());
        List<String> inputData = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(reader.readLine());

            for (int j = 0; j < 2; j++) {
                inputData.add(String.format("%5s", st.nextToken()));
            }

            countData(inputData, numbers);
        }

        for (Integer i : answer) {
            writer.write(String.valueOf(i));
            writer.newLine();
        }

        writer.flush();
    }

    private static void countData(List<String> inputData, Map<String, String> numbers) {
        String[] input = inputData.get(0).split("");
        String[] change = inputData.get(1).split("");

        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            String s = numbers.get(input[i]);
            String s1 = numbers.get(change[i]);

            if (" ".equals(s) && " ".equals(s1)) {
                continue;
            }

            char[] charArray = s.toCharArray();
//            System.out.println("s: " + Arrays.toString(charArray));
            char[] charArray1 = s1.toCharArray();
//            System.out.println("s1:" + Arrays.toString(charArray1));

            for (int j = 0; j < 7; j++) {
                if (charArray[j] != charArray1[j]) {
                    cnt++;
                }
            }

//            System.out.println("cnt: " + cnt);
        }

        answer.add(cnt);
        inputData.clear();
    }
}
