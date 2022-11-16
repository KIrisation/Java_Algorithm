package programmers.lv0.day14;

/**
 * 정수 배열 array와 정수 n이 매개변수로 주어질 때, array에 들어있는 정수 중 n과 가장 가까운 수를 return 하도록 solution 함수를 완성해주세요.
 * array	n	result [3, 10, 28]	20	28 [10, 11, 12]	13	12
 * 제한사항
 * - 1 ≤ array의 길이 ≤ 100
 * - 1 ≤ array의 원소 ≤ 100
 * - 1 ≤ n ≤ 100
 * *************가장 가까운 수가 여러 개일 경우 더 작은 수를 return 합니다.*******************
 */
public class CloseNumber {
// 길이, 절대값 컴퓨터의 메모리가 기억해야 할 값은 ? 최소 거리인 숫자값, 그때의 길이
    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 12, 14}, 13));
    }

    public static int solution(int[] array, int n) {
        int minDistance = 100;
        int targetNumber = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int distance = array[i] - n;

            if (distance < 0) {
                distance *= -1;
            }

            if (distance < minDistance) {
                minDistance = distance;
                targetNumber = array[i];
            }

            if (distance == minDistance) {
                if (targetNumber > array[i]) {
                    targetNumber = array[i];
                }
            }

        }

        return targetNumber;
    }

}
