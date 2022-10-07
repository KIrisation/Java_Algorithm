package ndb.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 게임 캐릭터가 맵 안에서 움직이는 시스템
 * 캐릭터가 있는 장소는 1 x 1 정사각형
 * 맵의 크기는 N x M 직사각형
 * 캐릭터는 동서남북 중 한 곳을 바라본다.
 * 맵의 각 칸은 (A, B)로 나타낼 수 있다.
 * A는 북쪽으로부터 떨어진 칸의 개수
 * B는 서쪽으로부터 떨어진 칸의 개수
 * 캐릭터는 상하좌우로 움직일 수 있고, 바다로 되어 있는 공간에 들어갈 수 없다.
 * 1. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향(반시계 방향으로 90도 회전한 방향) 부터 차례대로 갈 곳을 정한다.
 * 2. 캐릭터의 바로 왼쪽 방향에 아직 가보지 않은 칸이 존재한다면, 왼쪽 방향으로 회전한 다음 왼쪽으로 한 칸을 전진한다.
 * 왼쪽 방향에 가보지 않은 칸이 없다면, 왼쪽 방향으로 회전만 수행하고 1단계로 돌아간다.
 * 3. 만약 네 방향 모두 이미 가본 칸이거나 바다로 되어 있는 칸인 경우에는, 바라보는 방향을 유지한 채로 한칸 뒤로 가고 1단계로 돌아간다.
 * 단, 이때 뒤쪽 방향이 바다인 칸이라 뒤로 갈 수 없는 경우에는 움직임을 멈춘다.
 * <p>
 * - 0: 북쪽
 * - 1: 동쪽
 * - 2: 남쪽
 * - 3: 서쪽
 * <p>
 * 첫줄 = 세로 크기 N 과 가로 크기 M 을 공백으로 구분하여 입력한다.
 * 둘째 줄 = 게임 캐릭터가 있는 칸의 좌표(A,B)와 바라보는 방향 d 가 각각 서로 공백으로 구분하여 주어진다. 방향 d 의 값으로는 다음과 같이 4가지가 존재한다.
 */
public class GameDevelopment {
    protected static final int[] DX = {-1, 0, 1, 0}; // 북, 동, 남, 서
    protected static final int[] DY = {0, 1, 0, -1}; // 북, 동, 남, 서

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = bufferedReader.readLine();
        String[] firstLineArr = firstLine.split(" ");
        int row = Integer.parseInt(firstLineArr[0]);
        int column = Integer.parseInt(firstLineArr[1]);

        int[][] map2d = new int[row][column];
        boolean[][] checkMap = new boolean[row][column];
        for (boolean[] booleans : checkMap) {
            Arrays.fill(booleans, false);
        }


        String secondLine = bufferedReader.readLine();
        String[] sArr = secondLine.split(" ");
        int manRow = Integer.parseInt(sArr[0]);
        int manColumn = Integer.parseInt(sArr[1]);
        int manDirection = Integer.parseInt(sArr[2]);

        checkMap[manRow][manColumn] = true;

        for (int i = 0; i < row; i++) {
            String str = bufferedReader.readLine();
            String[] strArr = str.split(" ");
            for (int j = 0; j < column; j++) {
                map2d[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        int cnt = 0; // 총 이동 횟수
        int directionCnt = 0; // 방향 이동 횟수
        while (true) {
            manDirection--; // 시작 할 때 방향을 회전 시킴

            if (manDirection < 0) { // 방향을 회전 시킨 후 값이 -1 이면 해당 배열의 맨 끝으로 보냄
                manDirection = 3;
            }

            directionCnt++; // 유저 방향을 회전 시킨 후 회전 값을 1 증가 시킴

            int nextRow = manRow + DX[manDirection];
            int nextColumn = manColumn + DY[manDirection];

            if (map2d[nextRow][nextColumn] == 0 && !checkMap[nextRow][nextColumn]) { // 이동
                checkMap[nextRow][nextColumn] = true;
                manRow = nextRow;
                manColumn = nextColumn;
                cnt++;
                directionCnt = 0;

                continue;
            }

            if (directionCnt == 4) { // 4 방향 모두를 봤다
                int backRow = manRow - DX[manDirection];
                int backColumn = manColumn - DY[manDirection];

                if (map2d[backRow][backColumn] == 1) {
                    break;
                }
                manRow = backRow;
                manColumn = backColumn;
                cnt++;
                directionCnt = 0;
            }
        }
        System.out.println(cnt);
    }
}
/**
 * 보고 있는 방향을 반시계 방향으로 돌림
 * 북 동 남 서로 값을 저장해 놨기 때문에 반시계 방향은 --direction
 * 방향을 회전할 때 마다 directionCnt 를 증가시킴
 * 갈 수 있는 위치인지 확인
 *
 */