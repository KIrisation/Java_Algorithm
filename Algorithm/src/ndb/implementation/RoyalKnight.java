package ndb.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 체스판은 8 x 8 이다.
 * 나이트는 다음과 같은 2가지 경우로 이동할 수 있다.
 * 1. 수평으로 두 칸 이동한 뒤에 수직으로 한 칸 이동하기
 * 2. 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동하기
 */
public class RoyalKnight {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();

        String[] split = s.split("");

        int column = split[0].charAt(0) - 'a' + 1;
        int row = Integer.parseInt(split[1]);

        int[] knightMovingArrDx = {-2, -2, 2, 2, -1, -1, 1, 1};
        int[] knightMovingArrDy = {-1, 1, -1, 1, -2, 2, -2, 2};

        int count = 0;
        for (int i = 0; i < 8; i++) {
            int nextRow = row + knightMovingArrDx[i];
            int nextColumn = column + knightMovingArrDy[i];

            if (nextRow >= 1 && nextRow <= 8 && nextColumn >= 1 && nextColumn <= 8) {
                count += 1;
            }
        }
        System.out.println(count);
    }
}
/**
 * 1. 말의 위치를 찾는다.
 * 2. 말의 위치에서 최대로 움직일 수 있는 횟수는 8회 이다.
 * 3. 말이 이동중 장외로 이동하는 경우는 제외한다.
 */
