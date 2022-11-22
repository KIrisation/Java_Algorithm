package programmers.lv0.day18;

/**
 * 문제 설명
 * 어떤 자연수를 제곱했을 때 나오는 정수를 제곱수라고 합니다. 정수 n이 매개변수로 주어질 때, n이 제곱수라면 1을 아니라면 2를 return하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 1 ≤ n ≤ 1,000,000
 *
 * 입출력 예
 * n	result
 * 144	1
 * 976	2
 */
public class DetermineNumberOfSquares {

    public static void main(String[] args) {
        System.out.println(solution(144));
        System.out.println(solution(976));
    }

    public static int solution(int n) {
        for (int i = 1; i <= n; i++) {
            if (n == i * i) {
                return 1;
            }
        }

        return 2;
    }
}
