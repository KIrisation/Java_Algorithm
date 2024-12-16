package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer st;
        int[] S = new int[21];
        while (N-- > 0) {
            st = new StringTokenizer(reader.readLine());
            String command = st.nextToken();

            if ("add".equals(command)) {
                if (st.hasMoreTokens()) {
                    int x = Integer.parseInt(st.nextToken());
                    if (x >= 1 && x <= 20) {
                        S[x] = x;
                    }
                }
            } else if ("remove".equals(command)) {
                if (st.hasMoreTokens()) {
                    int x = Integer.parseInt(st.nextToken());
                    if (x >= 1 && x <= 20) {
                        S[x] = 0;
                    }
                }
            } else if ("check".equals(command)) {
                if (st.hasMoreTokens()) {
                    int x = Integer.parseInt(st.nextToken());
                    if (x >= 1 && x <= 20) {
                        writer.write(S[x] != 0 ? "1\n" : "0\n");
                    } else {
                        writer.write("0\n");
                    }
                }
            } else if ("toggle".equals(command)) {
                if (st.hasMoreTokens()) {
                    int x = Integer.parseInt(st.nextToken());
                    if (x >= 1 && x <= 20) {
                        S[x] = (S[x] == 0) ? x : 0;
                    }
                }
            } else if ("all".equals(command)) {
                for (int i = 1; i <= 20; i++) {
                    S[i] = i;
                }
            } else if ("empty".equals(command)) {
                Arrays.fill(S, 0);
            }
        }

        writer.flush();
    }
}
