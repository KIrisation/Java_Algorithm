package ndb.greedy;

import java.util.Scanner;

/**
 * 숫자 카드 게임은 여러 개의 숫자 카드 중에서 가장 높은 숫자가 쓰인 카드 한장을 뽑는 게임이다.
 * 단, 게임의 룰을 지키며 카드를 뽑아야 하고 룰은 다음과 같다.
 * 1. 숫자가 쓰인 카드들이 N x M 형태로 놓여 있다. 이때 N은 행의 개수를 의미하며, M은 열의 개수를 의미한다.
 * 2. 먼저 뽑고자 하는 카드가 포함되어 있는 행을 선택한다.
 * 3. 그다음 선택된 행에 포함된 카드들 중 가장 숫자가 낮은 카드를 뽑아야 한다.
 * 4. 따라서 처음에 카드를 골라낼 행을 선택할 때, 이후에 해당 행에서 가장 숫자가 낮은 카드를 뽑을 것을 고려하여 최종적으로
 *    최종적으로 가장 높은 숫자의 카드를 뽑을 수 있도록 전략을 세워야 한다.
 */
public class NumberCardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = scanner.nextInt();
        int height = scanner.nextInt();
        int [][] arr = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int [] compareArr = new int[height];
        for (int i = 0; i < height; i++) {
            int minNum = arr[0][0];
            for (int j = 0; j < width; j++) {
                if (arr[i][j] <= minNum) {
                    minNum = arr[i][j];
                }
            }
            compareArr[i] = minNum;
        }

        int maxNum = 0;
        for (int i = 0; i < height; i++) {
            if (maxNum <= compareArr[i]) {
                maxNum = compareArr[i];
            }
        }

        System.out.println(maxNum);
    }
}
/**
 * bunsung92 의 해설
 * 각줄마다 배열을 읽는다. 해당 배열은 2차원 배열이다.
 * 각줄마다 배열을 읽어서 가장 작은수 또는 가장 작은수와 같은 수를
 * 새로운 배열에다가 담는다.
 * 해당 배열은
 * 0 이 첫번째줄
 * 1 이 두번째줄 형식이다.
 * 최종 배열까지 읽어서 각 배열의 값을 비교한뒤
 * 최대값 구한다.
 *
 * 필요 = 새로운 배열, 최대값 변수, 최솟값 변수
 */