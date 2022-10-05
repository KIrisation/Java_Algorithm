package ndb.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 여행가 A 는 N x N 크기의 정사각형 공간 위에 서 있다.
 * 이 공간은 1 x 1 크기의 정사각형으로 나누어져 있다.
 * 가장 왼쪽 위 좌표는 (1, 1) 이며, 가장 오른쪽 아래 좌표는 (N, N)에 해당한다.
 * 여행가 A 는 상, 하, 좌, 우 방향으로 이동할 수 있으며, 시작 좌표는 항상 (1,1)이다.
 * 여행가 A 는 이동할 계획이 적힌 계획서가 놓여 있다.
 * 계획서에는 하나의 줄에 띄어쓰기를 기준으로 하여 L, R, U, D 중 하나의 문자가 반복적으로 적혀있다.
 * 여행가 A 가 N x N 크기의 정사각형 공간을 벗어나는 움직임은 무시된다.
 * 공간의 크기를 나타내는 N이 주어진다.(1 <= N <= 100)
 * 여행가 A 가 이동할 계획서 내용이 주어진다. (1 <= 이동 횟수 <= 100)
 * 첫째 줄에 여행가 A가 최종적으로 도착할 지점의 좌표(X, Y)를 공백으로 구분하여 출력한다.
 */
public class UpDownLeftRight {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        String[] planner = bufferedReader.readLine()
                                         .split(" ");

        int[] a = {1, 1};

        for (int i = 0; i < planner.length; i++) {
            if (a[0] != 0 && a[1] != 0 && a[0] <= n && a[1] <= n) {
                if (planner[i].charAt(0) == 'U') {
                    a[0] = a[0] - 1;
                    if (a[0] == 0) {
                        a[0] = a[0] + 1;
                    }
                } else if (planner[i].charAt(0) == 'D') {
                    a[0] = a[0] + 1;
                } else if (planner[i].charAt(0) == 'L') {
                    a[1] = a[1] - 1;
                    if (a[1] == 0) {
                        a[1] = a[1] + 1;
                    }
                } else if (planner[i].charAt(0) == 'R') {
                    a[1] = a[1] + 1;
                }
            }
        }

        System.out.println(a[0] + " " + a[1]);
    }
}
/**
 * 필요 - 여행가 A 의 좌표 , L, R, U, D 의 좌표 값, 최종 도착할 좌표 값
 */
