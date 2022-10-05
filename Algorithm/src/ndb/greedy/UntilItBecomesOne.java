package ndb.greedy;

import java.util.Scanner;

/**
 * 어떠한 수 N이 될 때까지 다음의 두 과정 중 하나를 반복적으로 선택하여 수행하려고 한다.
 * 단, 두 번째 연산은 N이 K로 나누어떨어질 때만 선택할 수 있다.
 * 1. N에서 1을 뺀다.
 * 2. N을 K로 나눈다.
 * ex) N 은 17, K 는 4
 * 1번째 = 17 - 1 = 16
 * 2번째 = 16 / 4 = 4
 * 3번째 = 4 / 4 = 1
 * 실행 횟수를 출력 = 3
 * N을 1로 만드는 최소 횟수
 */
public class UntilItBecomesOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int attemptNum = 0;
        while (n != 1) {
            attemptNum++;
            if (n % k == 0) {
                n = n / k;
            } else {
                n = n - 1;
            }
        }
        System.out.println(attemptNum);
    }
}
/**
 * 핵심으로 이 문제에서 기억할 것은
 * 두가지 밖에 선택할 수 없다.
 * N에서 1을 빼던가
 * N을 K로 나누던가
 * 즉 N과 K 를 나눠서 나머지 값이 0이 아니면 무조건 뺀다.
 * 필요 = 최소 횟수 변수, 두개의 조건문
 */
