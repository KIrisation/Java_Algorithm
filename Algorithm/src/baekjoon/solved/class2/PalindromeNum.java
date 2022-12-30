package baekjoon.solved.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1259번: 팰린드롬수
 */
public class PalindromeNum {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        while (true) {
            sb = new StringBuilder(reader.readLine());
            String tmp = sb.toString();

            if (Integer.parseInt(sb.toString()) == 0) {
                break;
            }

            StringBuilder reverse = sb.reverse();

            if (tmp.equals(reverse.toString())) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    static String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
