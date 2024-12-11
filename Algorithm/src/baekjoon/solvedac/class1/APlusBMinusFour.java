package baekjoon.solvedac.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 10951번: A + B - 4
 */
public class APlusBMinusFour {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        inputAndOutput();
    }

    private static void inputAndOutput() throws IOException {
        while (true) {
            String s = br.readLine();

            if (s == null) {
                break;
            }

            st = new StringTokenizer(s);
            System.out.println(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
        }
    }
}
