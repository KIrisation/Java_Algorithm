package programmers.lv1;

import java.util.Arrays;

/**
 * 소수 찾기
 * 문제 설명
 * 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
 *
 * 소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
 * (1은 소수가 아닙니다.)
 *
 * 제한 조건
 * n은 2이상 1000000이하의 자연수입니다.
 * 입출력 예
 * n	result
 * 10	4
 * 5	3
 * 입출력 예 설명
 * 입출력 예 #1
 * 1부터 10 사이의 소수는 [2,3,5,7] 4개가 존재하므로 4를 반환
 *
 * 입출력 예 #2
 * 1부터 5 사이의 소수는 [2,3,5] 3개가 존재하므로 3를 반환
 *
 * 해당 문제 고려사항
 * 1. 소수를 만들어 내는데 여러 알고리즘이 사용되는 것을 기억해야한다.
 * 2. 에라토스테네스의 체 알고리즘을 이용해 시간 복잡도를 줄여야 한다.
 **/
 public class FindPrimeNumber {

    public static void main(String[] args) {
        System.out.println(solution(100));
    }

    public static int solution(int n) {
        int answer = 0;
        boolean[] primeNumberCheck = new boolean[n + 1];
        Arrays.fill(primeNumberCheck, true); // 결론적으로 해당 배열의 true 인 애가 소수다!
        primeNumberCheck[0] = false;
        primeNumberCheck[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (!primeNumberCheck[i]) {
                continue;
            }

            for (int j = i + i; j <= n; j += i) {
                primeNumberCheck[j] = false;
            }
        }

        for (boolean isPrimeNumber : primeNumberCheck) {
            if (isPrimeNumber) {
                ++answer;
            }
        }

        return answer;
    }
}
