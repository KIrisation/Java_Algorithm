package programmers.lv1.kakao;

import java.util.ArrayList;
import java.util.List;

public class SecretMap {
    private static List<List<String>> map = new ArrayList<>();

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }

        List<String> binaryListArr1 = new ArrayList<>();
        for (int i : arr1) {
            binaryListArr1.add(String.format("%0"+ n +"d", Long.parseLong(Long.toBinaryString(i))));
        }

        List<String> binaryListArr2 = new ArrayList<>();
        for (int i : arr2) {
            binaryListArr2.add(String.format("%0"+ n +"d", Long.parseLong(Long.toBinaryString(i))));
        }

        analyzeMap(binaryListArr1, binaryListArr2);

        String[] mapResult = new String[map.size()];

        for (int i = 0; i < map.size(); i++) {
            String result = "";
            for (int j = 0; j < map.get(i).size(); j++) {
                result += map.get(i).get(j);
            }
            mapResult[i] = result;
        }

        return mapResult;
    }

    private static void analyzeMap(List<String> binaryListArr1, List<String> binaryListArr2) {
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < binaryListArr1.size(); j++) {
                if (binaryListArr1.get(i).charAt(j) == '1' || binaryListArr2.get(i).charAt(j) == '1') {
                    map.get(i).add("#");
                } else {
                    map.get(i).add(" ");
                }
            }
        }
    }
}
