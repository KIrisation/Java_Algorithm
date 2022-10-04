package ndb.greedy;

import java.util.Scanner;

/**
 * 배열의 크기 N
 * 숫자가 더해지는 횟수 M
 * 배열의 특정한 인덱스 (번호)에 해당하는 수가 연속해서 K번을 초과하여 더해질 수 없다.
 */
public class LawOfLargeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 배열의 크기
        int M = scanner.nextInt(); // 숫자가 더해지는 횟수
        int K = scanner.nextInt(); // 배열의 특정한 인덱스(번호)에 해당하는 수가 연속해서 K번을 초과하여 더해질 수 없다.

        int nArr[] = new int[N];

        for (int i = 0; i < N; i++) {
            nArr[i] = scanner.nextInt();
        }


        int firstMaxNum = 0;
        int secondMaxNum = 0;
        int firstMaxNumCursor = -1;
        for (int i = 0; i < N; i++) {
            if (firstMaxNum < nArr[i]) {
                firstMaxNum = nArr[i];
                firstMaxNumCursor = i;
            }
        }

        for (int i = 0; i < N; i++) {
            if (secondMaxNum <= nArr[i] && firstMaxNumCursor != i) {
                secondMaxNum = nArr[i];
            }
        }

        int count = 0;
        int sum = 0;
        for (int i = 0; i < M; i++) {
            if (count != K) {
                sum += firstMaxNum;
                count++;
            } else {
                count = 0;
                sum += secondMaxNum;
            }
        }

        System.out.println("최대 합은 : " + sum);
    }
}

