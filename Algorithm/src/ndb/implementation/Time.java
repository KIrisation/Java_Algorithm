package ndb.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 정수 N 이 입력되면 00시 00분 00초 부터 N시 59분 59초까지의 모든 시각 중에서
 * 3이 하나라도 포함되는 모든 경우의 수를 구하는 프로그램을 작성하시오.
 * 예를 들어 1을 입력했을 때 다음은 3이 하나라도 포함되어 있으므로 세어야 하는 시각이다.
 * - 00시 00분 03초
 * - 00시 13분 30초
 * 반면에 다음은 3이 하나도 포함되어 있지 않으므로 세면 안 되는 시각이다.
 * - 00시 02분 55초
 * - 01시 27분 45초
 */
public class Time {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = bufferedReader.read(); // 정수 N 시간이 입력됨.
        int count = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    String time = i + String.valueOf(j) + k;
                    if (time.contains("3")) {
                        ++count;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
