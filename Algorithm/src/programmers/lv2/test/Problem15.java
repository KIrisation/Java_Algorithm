package programmers.lv2.test;

public class Problem15 {

}

class Problem15Solution {

    static int[] result;
    static int cntZero;
    static int cntOne;

    int[] solution(int[][] arr) {
        // 처음 해야하는 행위
        // arr 돌아서 전체가 1인지 0인지 판단 후에 만약 맞으면 그대로 1또는 0으로 끝
        // 만약 전체가 1또는 0이 아니면 분할
        // 분할하고 나면 다시 분할된 배열을 돌아서 위를 반복

        recall(arr, arr.length, 0, 0);

        result[0] = cntZero;
        result[1] = cntOne;

        return result;
    }

    private static void recall(int[][] arr, int length, int startY, int startX) {
        int compareNum = arr[startY][startX];

        for (int i = startY; i < startY + length; i++) {
            for (int j = startX; j < startX + length; j++) {
                if (compareNum != arr[i][j]) {
                    recall(arr, length / 2, startY, startX);
                    recall(arr, length / 2, startY, startX + length / 2);
                    recall(arr, length / 2,  startY + length / 2, startX);
                    recall(arr, length / 2, startY + length / 2, startX + length / 2);

                    return; // 압축 하면 아래의 검증 로직을 타지 말아야 함.
                }
            }
        }

        if (compareNum == 0) { // 압축 할 때 검증 로직을 타야 함.
            cntZero++;
        } else {
            cntOne++;
        }
    }
}