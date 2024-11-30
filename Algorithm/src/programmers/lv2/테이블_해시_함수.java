package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class 테이블_해시_함수 {

    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        //오름차순 정렬 naturalOrder();
        //내림차순 정렬 reverseOrder();

        int column = col - 1;
        int pk = 0;
        int[] swap = new int[data[0].length];
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i][column] > data[i + 1][column]) {
                swap = data[i];
                data[i] = data[i + 1];
                data[i + 1] = swap;
            } else if(data[i][column] == data[i + 1][column]) {
                if (data[i][pk] < data[i + 1][pk]) {
                    swap = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = swap;
                }
            }
        }

        List<Integer> results = new ArrayList<>();

        for (int i = row_begin - 1; i < row_end - 1; i++) {
            int sum = 0;
            for (int j = 0; j < data[0].length; j++) {
                sum += (data[i][j] /  i + 1);
            }
            results.add(sum);
        }

        int finalSum = 0;
        for (Integer result : results) {
            finalSum += result;
        }

        return finalSum;
    }
}
