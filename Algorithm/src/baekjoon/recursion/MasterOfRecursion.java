package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MasterOfRecursion {

}

class MainMasterOfRecursion {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static List<String> palindromes = new ArrayList<>();
    static List<Integer> results = new ArrayList<>();
    static List<Integer> calls = new ArrayList<>();

    static void input() {
        // 첫줄 테스트 케이스의 개수 T
        N = scan.nextInt();

        // N번 만큼 각 줄을 읽어서 문자열 배열에 저장
        for (int i = 0; i < N; i++) {
            palindromes.add(scan.nextLine());
        }
    }

    public static int recursion(String s, int l, int r, int callCnt) {
        if (l >= r) {
            calls.add(callCnt);
            return 1;
        } else if (s.charAt(l) != s.charAt(r)) {
            calls.add(callCnt);
            return 0;
        } else {
            return recursion(s, l + 1, r - 1, callCnt + 1);
        }

    }

    public static int isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1, 1);
    }

    static void output() throws IOException {
        scan.output();
    }

    public static void main(String[] args) throws IOException {
        input();

        for (int i = 0; i < N; i++) {
            results.add(isPalindrome(palindromes.get(i)));
        }

        output();
    }

    static class FastReader {

        BufferedReader br;
        BufferedWriter bw;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        void output() throws IOException {
            for (int i = 0; i < N; i++) {
                bw.write(results.get(i) + " ");
                bw.write(calls.get(i) + "\n");
            }

            bw.flush();
        }
    }
}
